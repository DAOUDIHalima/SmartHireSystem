package org.shp.api_gateway.services.facade;

import org.apache.catalina.User;

public interface UserService {

    User findUserById(int id);

    void deleteUserById(int id);

    User updateUser(User user);

}
