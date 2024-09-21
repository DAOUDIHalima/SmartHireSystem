package org.shp.user_service.repositories;

import org.shp.user_service.models.ERole;
import org.shp.user_service.models.Role;
import org.shp.user_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    User findByUsername(String username);
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = :role")
    List<User> findByRole(@Param("role") ERole role);
}
