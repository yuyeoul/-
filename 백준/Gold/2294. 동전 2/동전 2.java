import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int P=sc.nextInt();
		int[] coin=new int [N];
		int[] dp=new int[P+1];
		for(int i=0;i<N;i++) {
			coin[i]=sc.nextInt();
		}
		for(int i=0;i<=P;i++) {
			dp[i]=1234567890;
		}
		dp[0]=0;
		Arrays.sort(coin);
		for(int i=0;i<N;i++) {
			for(int j=coin[i];j<=P;j++) {
					dp[j]=Math.min(dp[j-coin[i]]+1, dp[j]);
			}
		}
		if(dp[P]>=1234567890) {
			System.out.println(-1);
		}else {
			System.out.println(dp[P]);
		}
	}

}
