import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();

		int nc = n - c;
		int ans = 0;
		if (n == c||c==0) {
			ans = 1;
		} 
		 else if (n == 1 || c == 1 || nc == 1) {
			ans = n;
		} else {
			for (int i = n - 1; i >= 1; i--) {
				n *= i;
			}
			for (int i = c - 1; i >= 1; i--) {
				c *= i;
			}
			for (int i = nc - 1; i >= 1; i--) {
				nc *= i;
			}
			ans = n / nc / c;
		}
		System.out.println(ans);
	}

}
