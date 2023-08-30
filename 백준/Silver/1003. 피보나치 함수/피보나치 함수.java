import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int dp1[] = new int[41];
			int dp0[] =new int [41];
			dp1[1] = 1;
			dp0[1]=0;
			dp1[2] = 1;
			dp0[2]=1;
			
			if (N == 0) {
				System.out.println(1+" "+0);
			} else if (N == 1) {
				System.out.println(0+" "+1);
			} else if (N == 2) {
				System.out.println(1+" "+1);
			} else {
				for (int i = 3; i < 41; i++) {
					dp1[i] = dp1[i - 2] + dp1[i - 1];
					dp0[i]=dp0[i-2]+dp0[i-1];
				}
				System.out.println(dp0[N]+" "+dp1[N]);
			}
			

		}
	}

}
