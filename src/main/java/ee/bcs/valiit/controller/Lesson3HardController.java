package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HardController {
    Random random = new Random();
    int randomNumber = random.nextInt(100);
    int count = 0;

    // http://localhost:8080/lesson3hardcontroller/guess?a=5
    @GetMapping("lesson3hardcontroller/guess")
    public String guess(int a) {
        System.out.println(randomNumber);
        count++;
        if (a < randomNumber) {
            return "Sinu sisestatud nr on väiksem";
        } else if (a > randomNumber) {
            return "Sinu sisestatud nr on suurem";
        } else {
            int tmpCount = count;
            count = 0;
            randomNumber = random.nextInt(100);
            return "Sinu sisestatud nr on õige, sul läks " + tmpCount + " korda äraarvamiseks";
        }
    }
}
