import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int tc = 1; tc <= N; tc++) {
			int island = sc.nextInt();
			int S = 0;
			for (int i = island - 1; i >= 1; i--) {
				S += i;
			}
			int x[] = new int[island];
			int y[] = new int[island];
			for (int i = 0; i < island; i++) {
				x[i] = sc.nextInt();
			}
			for (int i = 0; i < island; i++) {
				y[i] = sc.nextInt();
			}
			double E = sc.nextDouble();
			double edges[][] = new double[S][3];
			int idx = 0;
			for (int i = 0; i < island - 1; i++) {
				for (int j = i + 1; j < island; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					edges[idx][2] = (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2))*E;
					idx++;
				}
			}

			Arrays.sort(edges, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}

			});

			p = new int[island];
			for (int i = 0; i < island; i++) {
				p[i] = i;
			}

			double ans = 0;
			int pick = 0;

			for (int i = 0; i < S; i++) {
				// i번째 간선 이용하여 두개의 정점을 가지고 처리
				int xi = (int) edges[i][0];
				int yi = (int) edges[i][1];

				int px = findset((int) edges[i][0]);
				int py = findset((int) edges[i][1]);
//				if(findset(x)!=findset(y)) {
				if (px != py) {
					// 여기에 들어왔다라는 뜻은 사이클이 형성이 안된다
//					union(x,y);
					union(px, py);
					ans += edges[i][2];
					pick++;
				}
				if (pick == S - 1) {
					break;
				}
			}
			System.out.println("#"+tc+" "+(long)Math.round(ans));
		}
	}

	static void union(int x, int y) {
		p[findset(y)] = findset(x);

	}

	static int findset(int x) {
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
}
