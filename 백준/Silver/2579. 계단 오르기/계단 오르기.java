import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		int dp[]=new int [301];
		int sco[]=new int[301];
		for(int i=1;i<=T;i++) {
			sco[i]=sc.nextInt();
		}
		dp[1]=sco[1];
		dp[2]=dp[1]+sco[2];
		dp[3]=sco[3]+Math.max(sco[1], sco[2]);
		for(int i=4;i<=T;i++) {
			dp[i]=sco[i]+Math.max(sco[i-1]+dp[i-3], dp[i-2]);
		}
		System.out.println(dp[T]);
	}

}
