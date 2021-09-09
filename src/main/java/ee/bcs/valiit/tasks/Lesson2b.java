package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        System.out.println(Arrays.toString(reverseArray(new int[]{2, 5, 8, 3, 4, 1, 9})));
        System.out.println(Arrays.toString(evenNumbers(4)));
        System.out.println(min(new int[]{2, 4, 5, -2, -1}));
        System.out.println(max(new int[]{2, 4, 5, -2, -1}));
        System.out.println(sum(new int[]{2, 4, 5, -2, -1}));
        multiplyTable(4, 3);
        System.out.println(fibonacci(8));

    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {

        for (int i = 0; i < inputArray.length / 2; i++) {
            int helpNumber;
            //System.out.println(Arrays.toString(inputArray));

            helpNumber = inputArray[inputArray.length - (i + 1)];
            inputArray[inputArray.length - (i + 1)] = inputArray[i];
            inputArray[i] = helpNumber;
        }
        return inputArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] array = new int[n];
        //int j = 0;
        for (int i = 1; i <= n * 2; i++) {
            if (i % 2 == 0) {
                // System.out.println(i);
                array[i / 2 - 1] = i;
                //j++;
            }
        }
        return array;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
        //int minValue = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < x[0]) {      // (x[i] < minValue)
                x[0] = x[i];        // minValue = x[i];
            }
        }
        return x[0];                // return minValue;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {        // System.out.println(max(new int[]{2, 4, 5, -2, -1}));
            if (x[i] > largest) {
                largest = x[i];
            }
        }
        return largest;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
            //sum += i;
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            for (int i = 1; i < n; i++) {
                int tmp = a;
                a = b;
                b = tmp + a;
                //System.out.println(i);
            }
            return b;
        }

//        if (n == 0) {
//            return 0;
//        } else if (n==1){
//            return 1;
//        } else {
//            return fibonacci(n-2)+fibonacci(n-1);
//        }
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

    public static int sequence3n(int x, int y) {
        return 0;
    }


}
