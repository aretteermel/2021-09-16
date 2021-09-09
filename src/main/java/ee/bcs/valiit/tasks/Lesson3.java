package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(reverseString("tere"));
        System.out.println(isPrime(11));
        System.out.println(Arrays.toString(sort(new int[]{5, 2, 3, 1, 4, 9, 8})));
        System.out.println(evenFibonacci(8));
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int sum = 1;
        for (int i = 1; i <= x; i++) {
            sum = sum * i;
        }
        return sum;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String reverse = "";
        for (int i = 0; i < a.length(); i++) {
            reverse = a.charAt(i) + reverse;
        }
        return reverse;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if ((x == 0) || (x == 1)) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            //System.out.println(i);
            //int helpNumber = x % i;
            //System.out.println(helpNumber);
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {

        for (int i = 0; i < a.length-1; i++) {
            int helpNumber;
            if (a[i] > a[i+1]) {
                helpNumber = a[i+1];
                a[i+1] = a[i];
                a[i] = helpNumber;
            }
            for (int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j+1]) {
                    helpNumber = a[j+1];
                    a[j+1] = a[j];
                    a[j] = helpNumber;
                }
            }
        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int sum = 0;
            for (int i = 1; i < x; i++) {
                int tmp = a;
                //System.out.println(tmp + "+++");
                a = b;
                //System.out.println("+++"+a);
                b = tmp + a;
                //System.out.println("===" + b);
                if(b > x) {
                    return sum;
                }
                if (b % 2 == 0) {
                    sum = sum + b;
                }
            }
            return b;
        }
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga

        return "";
    }
}
