package com.example.msproductcatalog.dao.repository;

import com.example.msproductcatalog.dao.entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
Optional<UserEntity> findByUsername(String username);
}
