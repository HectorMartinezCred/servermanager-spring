package com.brushbrosh.servermanagerspring.resource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brushbrosh.servermanagerspring.enumeration.Status;
import com.brushbrosh.servermanagerspring.model.Response;
import com.brushbrosh.servermanagerspring.model.Server;
import com.brushbrosh.servermanagerspring.service.implementation.ServerServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    private final ServerServiceImpl serverServiceImpl;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("servers", serverServiceImpl.list(30)))
                    .message("Servers retrieved")
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverServiceImpl.ping(ipAddress);
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("server", server))
                    .message(server.getStatus() == Status.SERVER_UP ? "Ping success" : "Ping failed")
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("server", serverServiceImpl.create(server)))
                    .message("Server created")
                    .status(HttpStatus.CREATED)
                    .statusCode(HttpStatus.CREATED.value())
                    .build()
        );
    }
}
