package com.brushbrosh.servermanagerspring.service;

import java.util.Collection;

import com.brushbrosh.servermanagerspring.model.Server;

public interface ServerService {
    Server create(Server server);
    Server ping(String ipAddress);
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
