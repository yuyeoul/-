import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class info {
		int x, y;

		public info(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int n;
	static List<info> list;

	public static void main(String[] args) {
		// 상근이 집에서 출발, 맥주 20개가 들어있는 한 박스 들고 출발함
		// 50미터마다 한 병씩 마신다
		// 빈 병을 버리고 편의점에서 새로운 맥주를 구매 가능하나 들고 있을 수 있는 최대 맥주는 20병이다

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 편의점의 수
			n = sc.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list.add(new info(x, y));
			}
			bfs();
		}
	}

	public static void bfs() {
		Queue<info> q = new LinkedList<>();
		boolean visited[] = new boolean[n + 2];
		visited[0] = true;
		q.add(new info(list.get(0).x, list.get(0).y));
		while (!q.isEmpty()) {
			info in = q.poll();
			if (Math.abs(in.x - list.get(list.size() - 1).x) + Math.abs(in.y - list.get(list.size() - 1).y) <= 1000) {
				System.out.println("happy");
				return;	
			}
			for (int i = 1; i < list.size()-1 ; i++) {
				if (!visited[i]) {
					if (Math.abs(in.x - list.get(i).x) + Math.abs(in.y - list.get(i).y) <= 1000) {
						visited[i] = true;
						q.add(new info(list.get(i).x, list.get(i).y));
					}
				}
			}
		}
		System.out.println("sad");
	}

}
