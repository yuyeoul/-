import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x_max = sc.nextInt();
		int y_max = sc.nextInt();

		int fx = sc.nextInt();
		int fy = sc.nextInt();

		int time = sc.nextInt();

		int x_move = 1;
		int y_move = 1;

		

		int xm = time % (2 * x_max);
		int ym = time % (2 * y_max);

		if (xm == 0 && ym == 0) {
			fx = fx;
			fy = fy;
		} else {
			for (int i = 1; i <= xm; i++) {
				fx += x_move;
				if (fx == x_max) {
					x_move = -1;
				} else if (fx == 0) {
					x_move = 1;
				}
			}
			for (int i = 1; i <= ym; i++) {
				fy += y_move;
				if (fy == y_max) {
					y_move = -1;
				} else if (fy == 0) {
					y_move = 1;
				}
			}

		}


		System.out.print(fx + " " + fy);

	}

}