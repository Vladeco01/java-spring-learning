package com.learn.springcoredemo.rest;

import com.learn.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
//    private Coach anotherCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach /*,
                          @Qualifier("cricketCoach") Coach theAnotherCoach*/){
        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
    }
    //Qualifier is used for specifying the bean for injection in case there are multiple interface implementations

    //define a setter method for dependency injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
//    }
}
