package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        System.out.println(Arrays.toString(sampleArray()));
        System.out.println(Arrays.toString(firstN(3)));
        System.out.println(Arrays.toString(generateArray(3)));
        System.out.println(Arrays.toString(decreasingArray(3)));
        System.out.println(Arrays.toString(yl3(2)));
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int [] array = new int [5]; // array {0, 0, 0, 0, 0}
        array[0] = 1; // array {1, 0, 0, 0, 0}
        array[1] = 2; //  etc
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        return array;
        //return new int []{1,2,3,4,5}; //sellist kirjapilti ei lähe üldiselt vaja
    }

    // TODO tagasta n esimest arvu alates 1-st
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static int[] firstN(int n) {
        int[] array = new int [n]; // array pikkusega n
        int i = 0;
        while (i < n) {
            array[i] = i + 1;
            i++;
        }
        return array;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järgnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int [n];
        for (int j = 0; j < n; j++){
            array[j] = j + 1;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {

        if (n > 0) {                                // if (5 > 0)
            int[] array = new int [n + 1];          // int [] array = new int [5 + 1 (st 6 kohta väljastada)]
            for (int i = 0; i <= n; i++){           // for (int i = 0; i <= n; i++)     i=0 0+0=0   i=1 0+1=1   i=2 1+1=2   i=3 2+1=3   i=4 3+1=4   i=5 4+1=5
                array[i] = n - i;                   // array[i] = 5 - 3;                5-0=5       5-1=4       5-2=3       5-3=2       5-4=1       5-5=0
            }
            return array;

        } else if (n < 0) {
            int[] array = new int [-n + 1];
            for (int i = 0; i <= -n; i++){                                          //  i=0 0+0=0   i=1 0+1=1   i=2 1+1=2   i=3 2+1=3   i=4 3+1=4   i=5 4+1=5
                array[i] = n + i;                                                   //  -5+0=-5     -5+1=-4     -5+2=-3     -5+3=-2     -5+4=-1     -5+5=0
            }
            return array;
        } else if (n == 0) {
            int[] array = new int[n + 1];
            for (int i = 0; i <= 0; i++) {                                          //  i=0 0+0=0
                array[i] = n + 0;                                                   //  0+0=0
            }
            return array;
        }
        return new int[0];
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array = new int [n];
        for (int i = 0; i < n; i++){
            array[i] = 3;
        }
        return array;
    }
}
