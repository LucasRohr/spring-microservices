package com.eureka.micro.gallery.controller;

import com.eureka.micro.gallery.domain.Gallery;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("")
public class GalleryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GalleryController.class);

    @Autowired
    Environment env;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
    }

    @HystrixCommand(fallbackMethod = "getGalleryFallback")
    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable("id") final Long id) {
        LOGGER.info("Creating gallery object ... ");

        Gallery gallery = new Gallery();
        gallery.setId(id);

        System.out.println("id " + id);

        List images = restTemplate.getForObject("http://image-service/images", List.class);
        gallery.setImages(images);

        LOGGER.info("Returning images ... ");
        return gallery;
    }

    public Gallery getGalleryFallback(Long galleryId, Throwable hystrixCommand) {
        return new Gallery(galleryId);
    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @GetMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

}
