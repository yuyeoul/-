import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num];
		int dp[]=new int[num];
		int max=-1001;
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		if(max<0) {
			System.out.println(max);
		}else {
		int sum=arr[0];
		dp[0]=arr[0];
		for (int i = 1; i < num; i++) {
			sum+=arr[i];
			if(sum<0) {
				dp[i]=0;
				sum=0;
			}else {
				dp[i]=Math.max(dp[i-1], sum);
			}
		}
		int max1=0;
		for(int i=0;i<num;i++) {
			if(dp[i]>max1) {
				max1=dp[i];
			}
		}
		System.out.println(max1);
		}
	}

}
