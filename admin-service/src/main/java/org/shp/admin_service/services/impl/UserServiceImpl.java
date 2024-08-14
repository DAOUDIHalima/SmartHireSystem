package org.shp.admin_service.services.impl;

import org.shp.admin_service.feignclients.ApiGatewayUserClient;
import org.shp.admin_service.models.User;
import org.shp.admin_service.services.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ApiGatewayUserClient apiGatewayUserClient;;


    public void banUSer(long id) {
        User user = apiGatewayUserClient.findById(id);
        if(user != null) {return;}
        user.setEnabled(false);
        apiGatewayUserClient.update(user);
    }


    public void unbanUSer(long id) {
        User user = apiGatewayUserClient.findById(id);
        if(user != null) {return;}
        user.setEnabled(true);
        apiGatewayUserClient.update(user);


    }
}
