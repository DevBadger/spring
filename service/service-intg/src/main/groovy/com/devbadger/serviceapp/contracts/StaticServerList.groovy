//package com.devbadger.serviceapp.contracts
//
//import com.netflix.loadbalancer.Server
//import com.netflix.loadbalancer.ServerList
//
///**
// * Created by Badger on 11/20/17.
// */
//class StaticServerList<T extends Server> implements ServerList<T>{
//    private final List<T> servers
//
//    StaticServerList(List<T> servers) {
//        this.servers = servers
//    }
//
//    @Override
//    List<T> getInitialListOfServers() {
//        servers
//    }
//
//    @Override
//    List<T> getUpdatedListOfServers() {
//        servers
//    }
//}
