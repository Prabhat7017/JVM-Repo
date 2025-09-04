package org.example.repository;

import org.bson.types.ObjectId;
import org.example.entity.JournalEntry;
import org.example.entity.JournalEntryV2;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;

public interface JournalEntryRepo extends MongoRepository<JournalEntryV2, ObjectId> {
}
