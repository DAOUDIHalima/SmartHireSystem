package org.shp.admin_service.feignclients;


import org.shp.admin_service.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "API-GATEWAY", path = "/api/user")
public interface ApiGatewayUserClient {
    @GetMapping("/id/{id}")
    User findUserById(@PathVariable Long id);

    @PutMapping("/update")
    User updateUser(@RequestBody User user);


}
