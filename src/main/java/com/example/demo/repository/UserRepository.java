//package com.example.demo.repository;
//
//import com.example.demo.Entity.User;
//import org.springframework.stereotype.Repository;
//import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
//import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
//import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
//import software.amazon.awssdk.services.dynamodb.model.ResourceInUseException;
//
//@Repository
//public class UserRepository {
//
//    private final DynamoDbTable<User> userTable;
//
//    public UserRepository(DynamoDbEnhancedClient enhancedClient) {
//        this.userTable = enhancedClient.table("Users", TableSchema.fromBean(User.class));
//
//        try {
//            // Create the table only if it doesn’t already exist
//            userTable.createTable();
//            System.out.println("✅ 'Users' table created in local DynamoDB.");
//        } catch (ResourceInUseException e) {
//            // Table already exists
//            System.out.println("⚠️ 'Users' table already exists, skipping creation.");
//        }
//    }
////
//    public void saveUser(User user) {
//        userTable.putItem(user);
//    }
//
//    public User getUser(String userId) {
//        return userTable.getItem(r -> r.key(k -> k.partitionValue(userId)));
//    }
//
//    public void deleteUser(String userId) {
//        userTable.deleteItem(r -> r.key(k -> k.partitionValue(userId)));
//    }
//}
