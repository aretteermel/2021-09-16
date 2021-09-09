package ee.bcs.valiit.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        System.out.println(someString());

        Scanner scanner = new Scanner(System.in);

//        System.out.println(min(1, 3));
//        System.out.println(max(1, 3));
//        System.out.println(abs(-1));
//        System.out.println(isEven(3));
//        System.out.println(min3(2, 2, 4));
//        System.out.println(max3(5, 4, 3));
        System.out.println("Sisesta allolevast loelelust üks number vastava funktsiooni jaoks");
        System.out.println("1 - min");
        System.out.println("2 - min");
        System.out.println("3 - abs");
        System.out.println("4 - even number");
        System.out.println("5 - min of three");
        System.out.println("6 - max of three");
        int command = scanner.nextInt();
        if(command == 1){
            System.out.println("Sisesta kaks arvu: a ja b");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("min = " + min(a,b));
        } else if(command == 2) {
            System.out.println("Sisesta kaks arvu: a ja b");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("max = " + max(a,b));
        } else if(command == 3) {
            System.out.println("Sisesta üks arv: a");
            int a = scanner.nextInt();
            System.out.println("abs = " + abs(a));
        } else if(command == 4) {
            System.out.println("Sisesta üks arv: a");
            int a = scanner.nextInt();
            System.out.println("even no = " + isEven(a));
        } else if(command == 5) {
            System.out.println("Sisesta kolm arvu: a, b ja c");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("min = " + min3(a,b,c));
        } else if(command == 6) {
            System.out.println("Sisesta kolm arvu: a, b ja c");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("max = " + max3(a,b,c));
        } else {
            System.out.println("Sisend ei vasta ühelegi tehtele");
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        String tekst = "\"\\\"\\\\\"\"";
        return tekst;
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return Math.abs(a);
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
        // saab ka nii: return max(a, max (b, c));
    }
}
