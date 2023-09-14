import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int V[]= new int [N+1];
		int W[]=new int[N+1];
		int dp [][]=new int [N+1][K+1];
		
		for(int i=1;i<N+1;i++) {
			W[i]=sc.nextInt();
			V[i]=sc.nextInt();
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				if(W[i]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(V[i]+dp[i-1][j-W[i]], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
		
	}

}
