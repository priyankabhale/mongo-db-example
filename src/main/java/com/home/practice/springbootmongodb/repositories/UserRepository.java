package com.home.practice.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.home.practice.springbootmongodb.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
