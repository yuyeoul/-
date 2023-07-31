import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			String x = Integer.toString((c / a) + 1);
			String y = Integer.toString(c % a);

			if (c % a == 0) {
				if (x.length() == 1||c/a==9) {
					System.out.println(Integer.toString(a) +"0"+Integer.toString(c / a));
				}else {
				System.out.println(Integer.toString(a) + Integer.toString(c / a));}
			} else {
				if (x.length() == 1) {
					System.out.println(y + "0" + x);
				}else {
					System.out.println(Integer.parseInt(y+x));
				}

			}

		}
	}

}
