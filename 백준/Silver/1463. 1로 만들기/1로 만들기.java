import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int dp[] = new int[10000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		if (num <= 3) {
			System.out.println(dp[num]);
		} else {
			for (int i = 4; i < num + 1; i++) {
				if (i % 6 == 0) {
					dp[i]=Math.min(Math.min(1 + dp[i / 3], 1 + dp[i / 2]), 1 + dp[i - 1]);
				} else if (i % 3 == 0) {
					dp[i] = Math.min(1 + dp[i / 3], 1 + dp[i - 1]);
				} else if (i % 2 == 0) {
					dp[i] = Math.min(1 + dp[i / 2], 1 + dp[i - 1]);
				} else {
					dp[i] = 1 + dp[i - 1];
				}

			}
			System.out.println(dp[num]);
		}

	}

}
