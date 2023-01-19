package com.ivan.server.controllers;

import com.ivan.server.entities.ServerItem;
import com.ivan.server.services.ServerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/server")
public class ServerController {

    @Autowired private ServerItemService serverItemService;

    @GetMapping("/process/{id}")
    public HttpStatus responseToClient(@PathVariable Integer id){
        return serverItemService.getStatus(id);
    }

    @GetMapping("/report")
    public List<ServerItem> listAll(){
        return serverItemService.findAll();
    }


}
