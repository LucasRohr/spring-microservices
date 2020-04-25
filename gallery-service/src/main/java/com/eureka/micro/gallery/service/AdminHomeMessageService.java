package com.eureka.micro.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class AdminHomeMessageService {

    @Autowired
    Environment env;

    public String getHomeAdminMessage() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

}
