import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		int dp[]=new int [2000];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0]=0;
		for(int i=0;i<N;i++) {	
			if(dp[i]>=Integer.MAX_VALUE) {
				continue;
			}
			for(int j=1;j<=arr[i];j++) {
				dp[i+j]=Math.min(dp[i]+1, dp[i+j]);
			}
			
		}
		if(dp[N-1]>=Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[N-1]);
		}
				
	}

}
