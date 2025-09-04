package org.example.repository;

import org.bson.types.ObjectId;
import org.example.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}
