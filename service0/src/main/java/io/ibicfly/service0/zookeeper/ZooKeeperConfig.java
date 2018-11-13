package io.ibicfly.service0.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Component
public class ZooKeeperConfig {

    public static void main(String[] args) {
        String url="ibicfly.club:2181";
        ZooKeeperConfig zooKeeperConfig = new ZooKeeperConfig();
        String host = url.split(":")[0];
        String port = url.split(":")[1];
        String zpath="/";
        List<String> zooChildren = new ArrayList<String>();

        ZooKeeper zk=null;
        try {
            zk = new ZooKeeper(host,Integer.parseInt(port),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (zk != null) {
            try {
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/': ");
                for (String child: zooChildren) {
                    //print the children
                    System.out.println(child);
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
