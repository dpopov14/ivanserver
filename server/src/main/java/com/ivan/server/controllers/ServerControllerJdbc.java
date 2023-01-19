package com.ivan.server.controllers;

import com.ivan.server.entities.ServerItem;
import com.ivan.server.services.impl.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/jdbc/server")
public class ServerControllerJdbc {

    @Autowired private JdbcService jdbcService;

    @GetMapping("/report")
    public List<ServerItem> getItems() throws SQLException {
        return jdbcService.getReportList();
    }
}
