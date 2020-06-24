import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static int cookies(int k, int[] A) {
        int hitung = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for(int i = 0; i < A.length; i++){
            q.add(A[i]);
        }

        while(q.peek() < k && q.size() >= 2){
            q.add(q.remove() + 2 * q.remove());
            hitung++;
        }

        if(q.size() == 1 && q.peek() < k){
            hitung = -1;
        }

        return hitung;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Your Output File Path"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
