package interviews;

public class N26Q2 {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int counter = 0;
        int p = A[0];
        boolean formHillOrValley = true;
        for (int i = 1; i < A.length; i++) {
            if (p != A[i]) {
                formHillOrValley = false;
            }
        }
        if (formHillOrValley) {
            return 1;
        } else {
            int len = A.length;
            int start = A[0];
            int end;
            for (int i = 1; i < len; i++) {
                if (A[i - 1] == A[i]) {
                    start = A[i - 1];
                    continue;
                }
                end = A[i+1];
                if (start < A[i] && end < A[i]) {
                    counter++;
                } else if (start > A[i] && end > A[i]) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
