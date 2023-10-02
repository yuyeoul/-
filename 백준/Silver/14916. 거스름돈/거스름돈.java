import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int dp[]=new int [100001];
		
		dp[0]=0;
		dp[1]=-1;
		dp[2]=1;
		dp[3]=-1;
		dp[4]=2;
		dp[5]=1;
		for(int i=6;i<dp.length;i++) {
			if(i%2==0) {
				if(i%5==0) {
					dp[i]=i/5;
				}else {
					dp[i]=dp[i-2]+1;
				}
			}else {
				if(i%5==0) {
					dp[i]= i/5;
				}else {
//					if(i%5%2==0) {
//						dp[i]=i/5+((i%5)/2);
//					}else {
						dp[i]=dp[i-2]+1;
//					}
				}
			}
		}
		System.out.println(dp[N]);
				
	}

}
