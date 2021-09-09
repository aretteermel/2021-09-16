package ee.bcs.valiit.tasks;

public class Lesson2c {

    public static void main(String[] args) {
        System.out.println(nextElement(11));
        System.out.println(getSeqLength(11));
        System.out.println();
        System.out.println(sequence3n(10, 12));

    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    // TODO 3
    //  tehke tsükkel x -> y
    //  kutsuge iga väärtuse korral välja meetodit getSeqLength
    //  salvestage maha kõige suurem ja funktsiooni lõpus tagastage leitud arv
    public static int sequence3n(int x, int y) {
        // tee seda for tsükliga
        int largest = 0;
        for (int abi = x; abi <= y; abi++) {
            System.out.println(abi);

            int abi2 = getSeqLength(abi);
            if(abi2 > largest){
                largest = abi2;
            }
            System.out.println(abi2);

        }
        return largest;
    }

    // TODO 2
    //  kutsuge välja meetodit nextElement nii kaua kuni vastus tuleb 1
    //  tagastage korduste arv + 1
    //  x = 1 ->1
    //  x = 2 -> 2
    //  x = 16 -> 5 (4 + 1)
    public static int getSeqLength(int x){
        // tee seda while tsükliga
        int count = 1;      // selle asemel et alguses kirjutada count = 0 ja lõpus kirjutada return count +1, väärtustan alguses kohe count = 1
        while (x > 1) {
            x = nextElement(x);
            count ++;
        }
        return count;
    }

    // TODO 1
    //  tagasta jada järgmine element
    //  x = 1 -> 4
    //  x = 2 -> 1
    //  x = 3 -> 10
    //  x = 10 -> 5
    public static int nextElement(int x){
        int nextElement;
        if (x % 2 == 0) {
            nextElement = x / 2;
            //System.out.println(nextElement);
        } else {
            nextElement = x * 3 + 1;
            //System.out.println(nextElement);
        }
        return nextElement;
    }

}
