import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int dp[]=new int[1001];
		int mod=10007;
		dp[1]=1;
		dp[2]=3;
		dp[3]=5;
		for(int i=4;i<num+1;i++) {
			dp[i]=(dp[i-2]*2+dp[i-1])%mod;
		}
		System.out.println(dp[num]);
	}

}
