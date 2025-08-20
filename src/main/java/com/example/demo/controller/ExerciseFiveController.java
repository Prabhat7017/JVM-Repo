//package com.example.demo.controller;
//
//import com.example.demo.services.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/exercise-five")
//public class ExerciseFiveController {
//    private final MessageService messageService;
//
//
//    public ExerciseFiveController(MessageService messageService) {
//        this.messageService = messageService;
//    }
//    @GetMapping("/message")
//    public String getMessage() {
//        return messageService.getMessage();
//    }
//}
