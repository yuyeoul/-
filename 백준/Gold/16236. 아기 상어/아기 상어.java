import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class fish implements Comparable<fish> {
		int r, c, t, v, s;

		public fish(int r, int c, int t, int v, int s) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
			this.v = v;
			this.s = s;
		}

		@Override
		public int compareTo(fish o) {
			if (t == o.t) {
				if (r == o.r) {
					return c - o.c;
				}
				return r - o.r;
			}
			return t - o.t;
		}

	}

	static int N;
	static int arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int size = 2;
	static int ans = 0;
	static boolean tf = false;
	static Queue<fish> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		fish fi = null;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 9) {
					fi = new fish(i, j, 0, 0, size);
				}
			}
		}
		while (true) {
			bfs(fi);
			if (tf == true) {
				break;
			}
		}

	}

	public static void bfs(fish f) {

		boolean visited[][] = new boolean[N][N];
		if (q.isEmpty()) {
			q.add(f);
			visited[f.r][f.c] = true;
			arr[f.r][f.c] = 0;
		}

		List<fish> list = new ArrayList<>();
		while (!q.isEmpty()) {
			fish fi = q.poll();
			visited[fi.r][fi.c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = fi.r + dr[i];
				int nc = fi.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if (arr[nr][nc] == 0) {
						q.add(new fish(nr, nc, fi.t + 1, fi.v, size));
						visited[nr][nc] = true;
					} else {
						if (arr[nr][nc] < size) {
							list.add(new fish(nr, nc, fi.t + 1, fi.v + 1, size));
							ans = fi.t + 1;
							visited[nr][nc] = true;
						}else if(arr[nr][nc]==size) {
							q.add(new fish(nr, nc, fi.t+1, fi.v, size));
							visited[nr][nc]=true;
						}
					}
				}
			}
		}
		if (list.size() == 0) {
			System.out.println(ans);
			tf = true;
			return;
		}
		Collections.sort(list);
		fish fi = list.get(0);
		if (fi.v == size) {
			size++;
			q.add(new fish(fi.r, fi.c, fi.t, 0, size));
		}
		arr[fi.r][fi.c] = 0;

		q.add(fi);
	}

}
