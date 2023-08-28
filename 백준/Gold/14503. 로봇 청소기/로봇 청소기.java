import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int dir = sc.nextInt();
		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 동서남북
		int dr[] = { 0, 0, 1, -1 };
		int dc[] = { 1, -1, 0, 0 };
		int ans = 0;
		clean: while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				ans++;
			}
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (map[nr][nc] != 0) {
					cnt++;
				}
			}
			if (cnt == 4) {
				if (dir == 0) {
					if (map[r + 1][c] == 1) {
						break;
					} else {
						r += 1;
						continue clean;
					}
				} else if (dir == 1) {
					if (map[r][c - 1] == 1) {
						break;
					} else {
						c -= 1;
						continue clean;
					}
				} else if (dir == 2) {
					if (map[r - 1][c] == 1) {
						break;
					} else {
						r -= 1;
						continue clean;
					}
				} else {
					if (map[r][c + 1] == 1) {
						break;
					} else {
						c += 1;
						continue clean;
					}
				}
			} else {
				if (dir == 0) {
					dir = 3;
					if (map[r][c - 1] == 0) {
						c -= 1;
					}
				} else if (dir == 1) {
					dir = 0;
					if (map[r - 1][c] == 0) {
						r -= 1;
					}
				} else if (dir == 2) {
					dir = 1;
					if (map[r][c + 1] == 0) {
						c += 1;
					}
				} else {
					dir = 2;
					if (map[r + 1][c] == 0) {
						r += 1;
					}
				}
			}

		}
		System.out.println(ans);
	}
}
