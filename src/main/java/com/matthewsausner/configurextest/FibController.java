package com.matthewsausner.configurextest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibController {
    
    @RequestMapping("/nextfib")
    public String fib(@RequestParam(value="userInput") String userInputStr) {

        int userInputInt;
        try {
            userInputInt = Integer.parseInt(userInputStr);
        } catch(NumberFormatException e) {
            return "You must enter a number.";
        }
        
        int currFib=0;
        int fibTemp=0;
        int fib1= 0;
        int fib2=1;
        while(userInputInt > currFib){
            fibTemp = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibTemp;
            currFib = fib1 + fib2;
        }
        if(userInputInt == currFib){ // if user input is a fib number
            currFib = currFib + fib2;
        }
        return Integer.toString(currFib);
    }
}