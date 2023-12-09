package ru.sl1degod.springsecurity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.sl1degod.springsecurity.models.Application;
import ru.sl1degod.springsecurity.models.MyUser;
import ru.sl1degod.springsecurity.services.AppService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apps")
@AllArgsConstructor
public class AppController {
    private AppService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the page";
    }

    @GetMapping("/all-app")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public List<Application> allApplications() {
        return service.allApplications();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public Application applicationByID(@PathVariable int id) {
        return service.applicationByID(id);
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        service.addUser(user);
        return "User is saved";
    }
}
