import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        //인풋 채우기
		int N = sc.nextInt();
		int arr[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
        //파이프의 상태가 가로,대각선,세로일 때를 각각 생각
		int dp[][][] = new int[N][N][3];
        //초기 파이프는 가로
		dp[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (arr[i][j] == 0) {
					// 가로
					if (j - 1 >= 0 && arr[i][j] == 0) {
						dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
					}
					// 세로
					if (i - 1 >= 0 && arr[i][j] == 0) {
						dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
					}
					// 대각
					if (i - 1 >= 0 && j - 1 >= 0 && arr[i][j] == 0 && arr[i][j - 1] == 0 && arr[i - 1][j] == 0) {
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					}
				}

			}
		}
        //가로,세로,대각으로 마지막지점에 도착하는 경우 모두 더해주기
		int sum = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
		System.out.println(sum);
	}

}
