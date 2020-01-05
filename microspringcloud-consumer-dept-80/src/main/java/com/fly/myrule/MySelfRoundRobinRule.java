package com.fly.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: zhanggq
 * @Description: 轮询算法-每节点访问5次，依次换下一个节点
 * @Date: 2020/1/2 0:01
 * @Version: 1.0
 **/
public class MySelfRoundRobinRule extends AbstractLoadBalancerRule {

    //每个节点访问的次数
    private int total = 0;

    //当前节点的序号
    private int cruurentIndex = 0;

    /**
     * Randomly choose from all living servers
     */
   // @edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

        /*    int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/

            //每个节点访问5次，依次换下一个节点
            if(total < 5){
                server = upList.get(cruurentIndex);
                total ++;
            }else {
                total = 0;
                cruurentIndex++;
                //当前的节点数不能超过所有存活节点的个数，保障服务可用
                if(cruurentIndex >= upList.size()){
                    cruurentIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

  /*  protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }*/

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
