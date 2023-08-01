import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int[] arr = new int[a];
		int cnt = 0;
		int index = 0;
		while (true) {
			if (arr[index] % 2 != 0) {
				arr[index] += 1;
				if (arr[index] == b) {
					System.out.println(cnt);
					break;
				} else {
					index += c;
					if (index > (a - 1)) {
						index -= a;
					}
					cnt++;

				}
			} else {
				arr[index] += 1;
				if (arr[index] == b) {
					System.out.println(cnt);
					break;
				} else {
					index -= c;
					if (index < 0) {
						index += a;
					}
					cnt++;
				}
			}

		}
	}

}