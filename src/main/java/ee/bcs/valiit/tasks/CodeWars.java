package ee.bcs.valiit.tasks;

public class CodeWars {
    public static void main(String[] args) {

        System.out.println(nthPower(new int[]{3, 1, 2, 2}, 3));


    }

    public static int nthPower(int[] x, int n) {
        if (n < x.length) {
            int a = 0;
            for (int i = 0; i < x.length; i++) {
                if (x[i] < n) {
                    a = x[i] = i * i;
                }
            }
            return a;
        }
        return -1;
    }
}


