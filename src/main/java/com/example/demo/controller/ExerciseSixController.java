package com.example.demo.controller;

import com.example.demo.models.CustomException;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@RequestMapping("/exercise-six")
public class ExerciseSixController {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseSixController.class);
    @GetMapping("/throw-exception")
    public String throwException() throws CustomException {
        logger.error("Throwing an exception for demonstration purposes");
        throw new CustomException("This is a custom exception message");
    }
}


//exercise-six/throw-exception