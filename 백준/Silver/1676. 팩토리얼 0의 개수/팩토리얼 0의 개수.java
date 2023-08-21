import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ans = num / 5;
		for (int i = 2; i <= 4; i++) {
			for(int j=1;j<=num;j++) {
			if (j % Math.pow(5, i) == 0) {
				ans++;
			}
			}
		}
		System.out.println(ans);
	}

}
