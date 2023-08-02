import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String s = sc.nextLine();
		for (int i = 0; i < num; i++) {
			String[] arra = sc.nextLine().split(" ");
			String[] arrb = sc.nextLine().split(" ");
			int a = Integer.parseInt(arra[0]);
			int b = Integer.parseInt(arrb[0]);
			int l = 0;
			if (a >= b) {
				l = a;
			} else {
				l = b;
			}
			int[] ara = new int[l];
			int[] arb = new int[l];
			for (int j = 0; j < a; j++) {
				ara[j] = Integer.parseInt(arra[j + 1]);
			}
			for (int j = 0; j < b; j++) {
				arb[j] = Integer.parseInt(arrb[j + 1]);

			}
			Arrays.sort(ara);
			Arrays.sort(arb);
			int cnt = 0;
			for (int j = l - 1; j >= 0; j--) {
				if (ara[j] != arb[j]) {
					if (ara[j] < arb[j]) {
						System.out.println("B");
					} else {
						System.out.println("A");
					}
					break;
				} else {
					cnt++;
				}
			}
			if (cnt == l) {
				System.out.println("D");
			}
		}
	}

}
