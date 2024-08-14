package org.shp.api_gateway.services.facade;

import org.apache.catalina.User;

public interface UserService {

    User findById(int id);

    void deleteById(int id);

    User update(User user);

}
