package com.ivan.server.services.impl;

import com.ivan.server.repositories.ServerItemRepository;
import com.ivan.server.services.ServerItemService;
import com.ivan.server.entities.ErrorStatus;
import com.ivan.server.entities.ServerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class ServerItemServiceImpl implements ServerItemService {

    @Autowired ServerItemRepository serverItemRepository;
    @Override
    public HttpStatus getStatus(Integer id) {
        Random random = new Random();
        int itemError = random.nextInt(100);
        if (itemError <= 9){
            String errorValue = ErrorStatus.values()[itemError].toString();
            ServerItem serverItem = new ServerItem();
            serverItem.setDescription(String.format("Item with id %d has error %s!", id, errorValue));
            serverItemRepository.save(serverItem);
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
    @Override
    public List<ServerItem> findAll() {
        return serverItemRepository.findAll();
    }
}
