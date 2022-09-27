package com.tracking.timetracking.repository;

import com.tracking.timetracking.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByNameAndPassword(String name, String password);

    Optional<UserModel> findFirstByName(String name);

    Optional<UserModel> findFirstByEmail(String email);
}
