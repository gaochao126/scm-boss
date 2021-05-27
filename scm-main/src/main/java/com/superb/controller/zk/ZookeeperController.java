package com.superb.controller.zk;

import com.alibaba.fastjson.JSONObject;
import com.superb.utils.ZkApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.superb.utils.WatcherApi;

import java.util.List;


@RestController
@RequestMapping(value = "zkController")
@Slf4j
public class ZookeeperController {

    @Autowired
    ZkApi zkApi;

    @GetMapping(value = "zkAdd")
    public String add() throws Exception {
        zkApi.createNode("/haha", "abcd");

        Stat stat = zkApi.exists("/haha", true);
        log.info("stat：{}", JSONObject.toJSON(stat));
        log.info("isExist：{}", zkApi.exists("/haha", new WatcherApi()));
        log.info("updateNode：{}", zkApi.updateNode("/haha", "update data xixi222"));
        log.info("getNode：{}", zkApi.getData("/haha", new WatcherApi()));
        return "ok";
    }


    @GetMapping(value = "zkAddC")
    public String addChild() throws Exception {
        zkApi.createNode("/haha/c1", "c1");
        zkApi.createNode("/haha/c2", "c2");


        log.info("c1：{}", zkApi.getData("/haha/c1", new WatcherApi()));
        log.info("c2：{}", zkApi.getData("/haha/c2", new WatcherApi()));

        List<String> children = zkApi.getChildren("/haha");
        return "ok";
    }


    @GetMapping(value = "zkDelete")
    public String delete() throws Exception {
        zkApi.deleteNode("/gaochao");
        zkApi.deleteNode("/gaochao/child1");
        zkApi.deleteNode("/gaochao/child2");

        log.info("获取子节点：{}", JSONObject.toJSONString(zkApi.getChildren("/gaochao")));
        log.info("获取/gaochao节点：{}", zkApi.getData("/gaochao", new WatcherApi()));
        return zkApi.getData("/gaochao", new WatcherApi());
    }
}
