package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Lesson3Controller {

    // http://localhost:8080/lesson3/factorial/5
    @GetMapping("lesson3/factorial/{x}")
    public int factorial(@PathVariable("x") int x) {
        return Lesson3.factorial(x);
    }

    // http://localhost:8080/lesson3/reversestring?a=tere
    @GetMapping("lesson3/reversestring")
    public String reverseString(@PathParam("a") String a) {
        return Lesson3.reverseString(a);
    }

    // http://localhost:8080/lesson3/isprime/3
    @GetMapping("lesson3/isprime/{x}")
    public boolean isPrime(@PathVariable("x") int x) {
        return Lesson3.isPrime(x);
    }

    // http://localhost:8080/lesson3/sort?array=5,8,4,1
    @GetMapping("lesson3/sort")
    public int[] sort(int[] array) {
        return Lesson3.sort(array);
    }

    // http://localhost:8080/lesson3/evenfibonacci/20
    @GetMapping("lesson3/evenfibonacci/{x}")
    public int evenFibonacci(@PathVariable("x") int x) {
        return Lesson3.evenFibonacci(x);
    }

    // http://localhost:8080/lesson3/morseCode TEGEMATA

}
