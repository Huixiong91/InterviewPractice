public class PrintSubSet {

    public static void main (String[] args) {

        int[] a = {1,2,3};
        for (int i = 0; i < (2 << (a.length - 1)); i++) { // natural presentation of all possible subsets of an array is a binary numbers from 0 - empty set, to 2 ^ (length of array - 1) - full set
            System.out.print("{");
            for (int j = 0; j < a.length; j++) { // loop over all array elements
                if (((i >> j) & 1) == 1) { // check if j'th bit of i (which is one of possible array's subsets) is enabled
                    System.out.print(a[j] + ",");
                }
            }
            System.out.println("}");
        }
    }
}
