package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import ee.bcs.valiit.tasks.Lesson2c;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Lesson2Controller {

    // http://localhost:8080/lesson2/samplearray
    @GetMapping("lesson2/samplearray")
    public int[] sampleArray() {
        return Lesson2.sampleArray();
    }

    // http://localhost:8080/lesson2/firstn/5
    @GetMapping("lesson2/firstn/{n}")
    public int[] firstN(@PathVariable("n") int n) {
        return Lesson2.firstN(n);
    }

    // http://localhost:8080/lesson2/generatearray?n=5
    @GetMapping("lesson2/generatearray")
    public int[] generateArray(@PathParam("n") int n) {
        return Lesson2.generateArray(n);
    }

    // http://localhost:8080/lesson2/decreasingarray/5
    @GetMapping("lesson2/decreasingarray/{n}")
    public int[] decreasinArray(@PathVariable("n") int n) {
        return Lesson2.decreasingArray(n);
    }

    // http://localhost:8080/lesson2/yl3?n=5
    @GetMapping("lesson2/yl3")
    public int[] yl3(@PathParam("n") int n) {
        return Lesson2.yl3(n);
    }

    // http://localhost:8080/lesson2b/reversearray?array=1,2,3,4
    @GetMapping("lesson2b/reversearray")
    public int[] reverseArray(int[] array) {
        return Lesson2b.reverseArray(array);
    }

    // http://localhost:8080/lesson2b/evennumbers/5
    @GetMapping("lesson2b/evennumbers/{n}")
    public int[] evenNumbers(@PathVariable("n") int n) {
        return Lesson2b.evenNumbers(n);
    }

    // http://localhost:8080/lesson2b/min?array=1,2,3,4
    @GetMapping("lesson2b/min")
    public int min(int[] array) {
        return Lesson2b.min(array);
    }

    // http://localhost:8080/lesson2b/max?array=1,2,3,4
    @GetMapping("lesson2b/max")
    public int max(int[] array) {
        return Lesson2b.max(array);
    }

    // http://localhost:8080/lesson2b/sum?array=1,2,3,4
    @GetMapping("lesson2b/sum")
    public int sum(int[] array) {
        return Lesson2b.sum(array);
    }

//    // http://localhost:8080/lesson2b/multiplytable/3/3
//    @GetMapping("lesson2b/multiplytable/{x}/{y}")
//    public void multiplyTable(@PathParam("x") int x, @PathParam("y") int y) {
//        return Lesson2b.multiplyTable(x, y);
//    }

    // http://localhost:8080/lesson2b/fibonacci/8
    @GetMapping("lesson2b/fibonacci/{n}")
    public int fibonacci(@PathVariable("n") int n) {
        return Lesson2b.fibonacci(n);
    }

    // http://localhost:8080/lesson2c/sequence3n/1/10
    @GetMapping("lesson2c/sequence3n/{x}/{y}")
    public int sequence3n(@PathVariable("x") int x, @PathVariable("y") int y) {
        return Lesson2c.sequence3n(x, y);
    }

}
