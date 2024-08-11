package org.shp.api_gateway.services.impl;

import org.apache.catalina.User;
import org.shp.api_gateway.services.facade.UserService;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        if (userRepository.existsById(id)) userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        User foundUser = findUserById(user.getId());
        if ((!foundUser.getUsername().equals(user.getUsername()) && userRepository.existsByUsername(user.getUsername())) || (!foundUser.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(user.getEmail())))
            return null;
        applyChanges(user, foundUser);
        return userRepository.save(foundUser);
    }


}
