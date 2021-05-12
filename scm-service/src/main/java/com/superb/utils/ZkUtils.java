package com.superb.utils;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import static org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values.CLIENT_PORT;

public class ZkUtils {
    public static void main(String[] args) throws Exception {

        // 创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper("localhost:2181", 5000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });

        createNodeSync(zk);
        getDataSync(zk);
    }


    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) { //判断是否已连接
            if(watchedEvent.getType() == Watcher.Event.EventType.None && null == watchedEvent.getPath()) {
                // 最初与zk服务器建立好连接
            } else if(watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                // 子节点变化事件
            }
            // ...还可以继续监听其它事件类型
        }
        System.out.println(watchedEvent.getState());
    }

    private static void createNodeSync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        String path = "/poype_node";
        String nodePath = zooKeeper.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(nodePath);
    }

    private static void getDataSync(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        // getData的返回值是该节点的数据值，节点的状态信息会赋值给stat对象
        byte[] data = zooKeeper.getData("/node_1",true, stat);
        System.out.println(new String(data));
        System.out.println(stat);
    }
}
