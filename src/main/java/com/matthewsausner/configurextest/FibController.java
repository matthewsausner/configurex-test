package com.matthewsausner.configurextest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;

@RestController
public class FibController {
    
    @RequestMapping("/nextfib")
    public String fib(@RequestParam(value="userInput") String userInputStr) {

        BigInteger userInputBig;
        //make sure input is numerical
        try {   
            //userInputInt = Integer.parseInt(userInputStr);
            userInputBig = new BigInteger(userInputStr);
        } catch(NumberFormatException e) {
            return "Invalid Input";
        }
        
        BigInteger currFib = BigInteger.ZERO;
        BigInteger fibTemp = BigInteger.ZERO;
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;
        //fib sequence is defined as fib(n) = fib(n-1) + fib(n-1), where fib(n) describes the nth fibinocci number
        while(userInputBig.compareTo(currFib) > 0){   // while userInputBig is greater than currFib
            fibTemp = fib1.add(fib2);
            fib1 = fib2;
            fib2 = fibTemp;
            currFib = fib1.add(fib2);
        }
        if(userInputBig.equals(currFib)){ // if user input is a fib number, return next fib number
            currFib = currFib.add(fib2);
        }
        return currFib.toString();
    }
}