import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int tc = 1; tc <= num; tc++) {
			int size = sc.nextInt();
			int stick = sc.nextInt();
			int N = size - stick;
			int[][] arr = new int[size][size];
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int l = 0; l <= N; l++) {
				for (int k = 0; k <= N; k++) {
					int sum=0;
					for (int i = l; i < l + stick; i++) {
						for (int j = k; j < k + stick; j++) {
							sum+=arr[i][j];

						}
					}
					list.add(sum);

				}
			}
			Collections.sort(list);
			System.out.println("#"+tc+" "+list.get(list.size()-1));
		}
	}

}