import java.util.Arrays;

public class Solution {

    static int minimumMoves(int[] a, int[] m) {
        int moves = 0;
        for (int i = 0; i < a.length; i++) {
        int num_a = a[i];
        int num_m = m[i];
        while (num_a > 0) {
            int digita = num_a % 10;
            int digitm = num_m % 10;
            while (digita != digitm) {
                moves++;
                if (digita < digitm) digita++;
                else digita--;
            }
            num_a = num_a / 10;
            num_m = num_m / 10;
        }
    }
        return moves;
}

    static long doubleSize(long[] a, long b) {
        Arrays.sort( a );
        return 1l;
    }

    public static int hammingDistance(int a, int b) {
//        int i = 0;
//        String string_x = Integer.toBinaryString(x);
//        String string_y = Integer.toBinaryString(y);
//
//        System.out.println(string_x);
//        System.out.println(string_y);
//
//        return i;
        return Integer.bitCount(a ^ b);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
