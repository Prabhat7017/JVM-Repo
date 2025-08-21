package com.example.demo.pojo;


import com.example.demo.Entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Builder
@Data
public class UserDetails {
    private int age;
    private String name;
    private String email;
    private String address;


//    private UserDetails(builder builder){
//        this.age = builder.age;
//        this.name = builder.name;
//        this.email = builder.email;
//        this.address = builder.address;
//    }

//    @Override
//    public String toString() {
//        return "UserDetails{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
//
//    public static class builder{
//        private int age;
//        private String name;
//        private String email;
//        private String address;
//
//        public builder setAge(int age) {
//            this.age = age;
//            return this;
//        }
//        public builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//        public builder setEmail(String email){
//            this.email= email;
//            return this;
//        }
//
//        public builder setAddress(String address) {
//            this.address = address;
//            return this;
//        }
//
//        public UserDetails build() {
//            return new UserDetails(this);
//        }
//    }
}


