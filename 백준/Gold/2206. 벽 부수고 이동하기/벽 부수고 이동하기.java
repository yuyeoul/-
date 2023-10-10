import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class info {
		int r, c, v;
		boolean bw;

		public info(int r, int c, int v, boolean bw) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.bw = bw;
		}

		@Override
		public String toString() {
			return "info [r=" + r + ", c=" + c + ", v=" + v + ", bw=" + bw + "]";
		}
		

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		String str[][] = new String[n][m];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next().split("");
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[i][j]);
			}
		}
		bfs();

	}

	public static void bfs() {
		Queue<info> q = new LinkedList<>();
		boolean visited[][][] = new boolean[n][m][2];
		q.add(new info(0, 0, 1, false));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			info in = q.poll();
			
			if (in.r == n - 1 && in.c == m - 1) {
				System.out.println(in.v);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = in.r + dr[i];
				int nc = in.c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if(in.bw==true) {
						if(!visited[nr][nc][1]) {
							if(arr[nr][nc]==1) {
								continue;
							}else {
								visited[nr][nc][1] = true;
								q.add(new info(nr, nc, in.v + 1, true));
							}
						}
					}else {
						if(!visited[nr][nc][0]) {
							if(arr[nr][nc]==1) {
								visited[nr][nc][1] = true;
								q.add(new info(nr, nc, in.v + 1, true));
							}else {
								visited[nr][nc][0] = true;
								q.add(new info(nr, nc, in.v + 1, false));
							}
						}
					}
				}
			}


		}
		System.out.println(-1);
		return;
	}

}
