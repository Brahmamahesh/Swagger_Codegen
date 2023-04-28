package com.kaiburrtask2.swagger_codegen.controller;


import com.kaiburrtask2.swagger_codegen.ServerRepository;
import com.kaiburrtask2.swagger_codegen.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

//To Implement the REST endpoint.
//we are using Spring annotations to define the REST endpoints '@RestController' and '@RequestMapping'

@RestController
@RequestMapping("/servers")
public class ServerController
{

    @Autowired
    private ServerRepository serverRepository;

    //This Method is used to redirect to swagger page
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        //To call the swagger API
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping
    public List<Server> getServers(@RequestParam(required = false) String id) {
        if (id == null) {
            return serverRepository.findAll();
        } else {
            return serverRepository.findById(id).map(Collections::singletonList).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
    }
    @PostMapping
    public Server addServer(@RequestBody Server server)
    {
        return serverRepository.save(server);
    }


    @PutMapping
    public void createServer(@RequestBody Server server) {
        serverRepository.save(server);
    }

    @DeleteMapping({"/{id}"})
    public void deleteServer(@PathVariable String id) {
        serverRepository.deleteById(id);
    }

    @GetMapping(params = "name")
    public List<Server> findServersByName(@RequestParam String name) {
        List<Server> servers = serverRepository.findByNameContaining(name);
        if (servers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return servers;
        }
    }
}
