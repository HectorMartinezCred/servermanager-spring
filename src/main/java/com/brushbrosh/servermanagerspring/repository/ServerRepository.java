package com.brushbrosh.servermanagerspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brushbrosh.servermanagerspring.model.Server;

public interface ServerRepository extends JpaRepository<Server, Long>{
    
    Server findByIpAddress(String ipAddress);

}
