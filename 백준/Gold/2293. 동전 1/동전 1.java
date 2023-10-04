import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		int[] coin = new int[N];
		int[] dp = new int[P + 1];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		dp[0] = 1;
		Arrays.sort(coin);
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= P; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}

		System.out.println(dp[P]);
	}

}
