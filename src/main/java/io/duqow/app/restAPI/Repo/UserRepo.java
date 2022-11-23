package io.duqow.app.restAPI.Repo;

import io.duqow.app.restAPI.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
