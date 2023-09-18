import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		int dp[]=new int[31];
		dp[1]=0;
		dp[2]=3;
		dp[3]=0;
		dp[4]=11;
		dp[5]=0;
		for(int i=6;i<num+1;i++) {
			if(i%2!=0) {
				dp[i]=0;
			}else {
				dp[i]=dp[i-2]*4-dp[i-4];
			}
		}
		System.out.println(dp[num]);
	}

}
