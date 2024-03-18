import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int idxA = 0;
        int idxB = listB.size() - 1;
        long ans = 0;

        while (idxA < listA.size() && idxB >= 0) {
            int sum = listA.get(idxA) + listB.get(idxB);
            if (sum == T) {

                int a = listA.get(idxA);
                int b = listB.get(idxB);
                long aCnt = 0;
                long bCnt = 0;

                while (idxA < listA.size() && listA.get(idxA) == a) {
                    aCnt++;
                    idxA++;
                }
                while (idxB >= 0 && listB.get(idxB) == b) {
                    bCnt++;
                    idxB--;
                }

                ans += aCnt * bCnt;
            } else if (sum < T)
                idxA++;

            else if (sum > T)
                idxB--;
        }

        System.out.println(ans);
    }
}
