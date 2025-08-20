package com.example.demo.controller;

import com.example.demo.models.MyPrototypeBean;
import com.example.demo.models.MySingletoneBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise-four")
public class ExerciseFourController {
    MyPrototypeBean myPrototypeBean;
    MySingletoneBean mySingletoneBean;
    MySingletoneBean mySingletoneBean2;

    @Autowired
    MyPrototypeBean myPrototypeBean2;


    public ExerciseFourController(MyPrototypeBean myPrototypeBean, MySingletoneBean mySingletoneBean, MySingletoneBean mySingletoneBean2) {
        this.myPrototypeBean = myPrototypeBean;
        this.mySingletoneBean = mySingletoneBean;
        this.mySingletoneBean2 = mySingletoneBean2;
    }

    @GetMapping("/prototype")
    public String getPrototypeBean() {
        return "Prototype Bean: " + myPrototypeBean.getMessage() + ", " +
                "Prototype Bean 2: " + myPrototypeBean2.getMessage() + ", " +
                "Singleton Bean: " + mySingletoneBean.getMessage() + ", " +
                "Singleton Bean 2: " + mySingletoneBean2.getMessage();
    }

}
