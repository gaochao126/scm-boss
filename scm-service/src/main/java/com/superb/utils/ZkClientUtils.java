package com.superb.utils;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * zkClient工具类
 */
public class ZkClientUtils implements Watcher {

    /**
     CreateMode类型分为4种
     1.PERSISTENT--持久型
     2.PERSISTENT_SEQUENTIAL--持久顺序型
     3.EPHEMERAL--临时型
     4.EPHEMERAL_SEQUENTIAL--临时顺序型
     注：
     1、2种类型客户端断开后不会消失
     3、4种类型客户端断开后超时时间内没有新的连接节点将会消息
     */

    private volatile static ZkClientUtils zkClient = null;
    private static String hostPort = "localhost:2181";
    private ZooKeeper zk = null;
    private NodeDataFunction nodeDataFunction = null;

    private ZkClientUtils(){
        this.initZk();
    }

    /**
     * 初始化对象
     * @return
     */
    public static ZkClientUtils getInstance(){
        if (zkClient == null){
            synchronized (ZkClientUtils.class) {
                if (zkClient == null)
                    zkClient = new ZkClientUtils();
            }
        }
        return zkClient;
    }

    /**
     * 初始化zk连接对象
     */
    private void initZk(){
        try {
            zk = new ZooKeeper(hostPort, 2000, this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 初始化zk节点
     * @param path
     */
    public void initZkNode(String path){
        this.run(()->{
            if (zk.exists(path, this) == null) {
                zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            List<String> zooChildren = listNodes(path);
            if (zooChildren != null){
                System.out.println("Znodes of '"+path+"': ");
                zooChildren.forEach(o-> System.out.println(o));
            }
        });
    }

    /**
     * 显示当前path下所有子节点
     * @param path
     * @return
     */
    public List<String> listNodes(String path){
        List<String> lists = new ArrayList<>();
        this.run(()->lists.addAll(zk.getChildren(path, this, null)));
        return lists;
    }

    /**
     * 创建节点
     * @param path
     * @param data
     */
    public void createNode(String path, String data){
        this.run(()->{
            if (zk.exists(path, this) == null) {
                zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);//持久保存
            } else {
                zk.setData(path, data.getBytes(), -1);
            }
        });
    }

    /**
     * 获取节点下的数据
     * @param path
     * @return
     */
    public String getData(String path){
        String data = "";
        this.run(()->{
            if (zk.exists(path, this) != null) {
                data.concat(new String(zk.getData(path, this, null)));
            }
        });
        return data;
    }

    /**
     * 设置节点数据
     * @param path
     * @param data
     */
    public void setData(String path, String data){
        createNode(path, data);
    }

    /**
     * 删除节点
     * @param path
     */
    public void deleteNode(String path){
        this.run(()->zk.delete(path, -1));
    }

    /**
     * 关闭ZK连接(建议在服务需停止时，才去关闭，否则应一直保持zk的连接是open的)
     */
    public void close(){
        if (zk != null){
            try{
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient = null;
    }

    /**
     * 执行节点逻辑
     * @param interFunction
     */
    private void run(InterFunction interFunction){
        try{
            interFunction.execute();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册业务对象
     * @param nodeDataFunction
     */
    public void register(NodeDataFunction nodeDataFunction){
        this.nodeDataFunction = nodeDataFunction;
    }

    /**
     * 该方法由Zk服务事件主动回调
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        //默认只有注册了nodeDataFunction接口的方法，由外部的调用代码块中才能执行，否则得单独实现事件逻辑
        if (nodeDataFunction != null) {
            try {
                nodeDataFunction.execute(watchedEvent, zk, this);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @FunctionalInterface
    interface InterFunction{
        void execute() throws KeeperException, InterruptedException;
    }

    @FunctionalInterface
    interface NodeDataFunction{
        void execute(WatchedEvent watchedEvent, ZooKeeper zk, Watcher watcher) throws KeeperException, InterruptedException;
    }

    /**
     * 测试，事件推送
     * @param args
     */
    public static void main(String[] args) {
        ZkClientUtils zkClientUtils = ZkClientUtils.getInstance();
        String path = "/zk_test_node";
        zkClientUtils.initZkNode(path);

        NodeDataFunction nodeData = (watchedEvent, monitorZk, watcher) -> {
            System.out.println(watchedEvent.getType());
            if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                System.out.println("发生节点变更...");
                List<String> zooChildren = monitorZk.getChildren(path, watcher, null);
                System.out.println("Znodes of '"+path+"': ");
                for (String child: zooChildren) {
                    System.out.println(child);
                }
            }else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                System.out.println("发生数据变更...");
                byte[] data = monitorZk.getData(path, watcher, null);
                System.out.printf("Current Data @ ZK Path %s: %s \n", path, new String(data));
            } else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                System.out.println("发生数据删除...");
            }
            System.out.println();
        };
        zkClientUtils.register(nodeData);

//        List<String> lists =  zkClientUtils.listNodes(path);
//        lists.forEach(o-> System.out.println(o));
        while(true){
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
