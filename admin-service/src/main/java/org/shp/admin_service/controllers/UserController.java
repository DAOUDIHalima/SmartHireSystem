package org.shp.admin_service.controllers;


import org.shp.admin_service.services.facade.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
   private  UserService userService;
   @GetMapping("/ban/{id}")
    public void banUser(@PathVariable int id) {
       userService.banUSer(id);
   }

   @GetMapping("unban/{id}")
    public void unbanUser(@PathVariable int id) {
       userService.unbanUSer(id);
   }


}
