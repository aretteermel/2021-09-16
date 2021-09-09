package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära arvamise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {

        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta üks number 0-99");
        int command = scanner.nextInt();
        int count = 1;
        while (count != i) {
            if (command > i) {
                System.out.println("Sinu sisestatud arv oli suurem, proovi uuesti");
                count++;
                command = scanner.nextInt();
            } else if (command < i) {
                System.out.println("Sinu sisestatud arv oli väiksem, proovi uuesti");
                count++;
                command = scanner.nextInt();
            } else if (command == i){
                System.out.println("Sinu sisestatud arv oli täpne, palju õnne");
                break;
            }
        }
        System.out.println("Sul läks " + count + " katset numbri ära arvamiseks");
    }
}