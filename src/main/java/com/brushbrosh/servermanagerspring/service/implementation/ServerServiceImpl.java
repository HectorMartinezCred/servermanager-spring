package com.brushbrosh.servermanagerspring.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.brushbrosh.servermanagerspring.enumeration.Status;
import com.brushbrosh.servermanagerspring.model.Server;
import com.brushbrosh.servermanagerspring.repository.ServerRepository;
import com.brushbrosh.servermanagerspring.service.ServerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService{

    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Server update(Server server) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    private String setServerImageUrl() {
        return null;
    }

}
