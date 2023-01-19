package com.ivan.server.services;

import com.ivan.server.entities.ServerItem;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface ServerItemService {
    HttpStatus getStatus(Integer id);

    List<ServerItem> findAll();
}
