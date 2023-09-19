import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class info {
		int z, x, y, day;

		info(int z, int x, int y, int day) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int h = sc.nextInt();
		int arr[][][] = new int[h][col][row];
		boolean visited[][][] = new boolean[h][col][row];
		int ans = 0;
		Queue<info> queue = new LinkedList<>();
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					arr[k][i][j] = sc.nextInt();
					if (arr[k][i][j] == 1) {
						queue.add(new info(k, i, j, 0));
						visited[k][i][j] = true;
					}
				}
			}
		}
		int dh[] = { 0, 0, 0, 0, 1, -1 };
		int dc[] = { -1, 1, 0, 0, 0, 0 };
		int dr[] = { 0, 0, 1, -1, 0, 0 };

		while (!queue.isEmpty()) {
			info to = queue.poll();
			ans = to.day;
			for (int i = 0; i < 6; i++) {
				int nz = to.z + dh[i];
				int nx = to.x + dc[i];
				int ny = to.y + dr[i];
				if (nz >= 0 && nz < h && nx >= 0 && nx < col && ny >= 0 && ny < row && !visited[nz][nx][ny]) {
					visited[nz][nx][ny] = true;
					if (arr[nz][nx][ny] == 0) {
						arr[nz][nx][ny] = 1;
						queue.add(new info(nz, nx, ny, to.day + 1));
					}
				}
			}
		}
		boolean flag = true;
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					if (arr[k][i][j] == 0) {
						flag = false;
					}
				}
			}
		}
		if (flag == true) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	}

}
