package com.eureka.micro.gallery.controller;
import com.eureka.micro.gallery.domain.Gallery;
import com.eureka.micro.gallery.service.AdminHomeMessageService;
import com.eureka.micro.gallery.service.GetGalleryService;
import com.eureka.micro.gallery.service.HomeMessageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class GalleryController {
    @Autowired
    private AdminHomeMessageService adminHomeMessageService;

    @Autowired
    private HomeMessageService homeMessageService;

    @Autowired
    private GetGalleryService getGalleryService;

    @GetMapping("/")
    public String home() {
        return homeMessageService.getHomeMessage();
    }

    @HystrixCommand(fallbackMethod = "getGalleryFallback")
    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable("id") final Long id) {
       return getGalleryService.getGallery(id);
    }

    public Gallery getGalleryFallback(Long galleryId, Throwable hystrixCommand) {
        return new Gallery(galleryId);
    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @GetMapping("/admin")
    public String homeAdmin() {
        return adminHomeMessageService.getHomeAdminMessage();
    }
}
