package com.eureka.micro.gallery.service;

import com.eureka.micro.gallery.controller.GalleryController;
import com.eureka.micro.gallery.domain.Gallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class GetGalleryService {
    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(GalleryController.class);

    public Gallery getGallery(Long id) {
        LOGGER.info("Creating gallery object ... ");

        Gallery gallery = new Gallery();
        gallery.setId(id);

        System.out.println("id " + id);

        List images = restTemplate.getForObject("http://image-service/images", List.class);
        gallery.setImages(images);

        LOGGER.info("Returning images ... ");
        return gallery;
    }
}
