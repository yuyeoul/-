import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int bing = 0;
		int cnt = 0;

		int dr[] = { 0, 1, 1, 1 };
		int dc[] = { 1, 0, 1, -1 };
		while (true) {
			int num = sc.nextInt();
			boolean trans = false;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == num) {
						map[i][j] = 0;
						cnt++;
						trans = true;
						break;
					}
				}
				if (trans == true) {
					break;
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							for (int cn = 1; cn <= 4;) {
								int nr = i + dr[k] * cn;
								int nc = j + dc[k] * cn;
								if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5&&map[nr][nc]==0) {
									cn++;
								}else {
									break;
								}
								if(cn==5) {
									bing++;
									break;
								}
							}
						}
					}
				}
			}
			if(bing>=3) {
				System.out.println(cnt);
				break;
			}else {
				bing=0;
			}
		}
	}
}
