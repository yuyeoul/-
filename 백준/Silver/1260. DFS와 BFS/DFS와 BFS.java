import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int V = sc.nextInt();
	static boolean[] visited = new boolean[N + 1];
	static List<List<Integer>> list = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int idx = sc.nextInt();
			int val = sc.nextInt();
			list.get(idx).add(val);
			list.get(val).add(idx);
			Collections.sort(list.get(idx));
			Collections.sort(list.get(val));
		}
		DFS(V);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(V);

	}

	static void DFS(int v) {
		visited[v]=true;
		System.out.print(v+" ");
		for(int c:list.get(v)) {
			if(!visited[c]) {
				DFS(c);
			}
		}
	}

	static void BFS(int v) {
		queue.add(v);
		visited[v] = true;
		while (!queue.isEmpty()) {
			int t = queue.poll();
			System.out.print(t + " ");

			for (int c : list.get(t)) {
				if (!visited[c]) {
					queue.add(c);
					visited[c] = true;
				}
			}

		}
	}

}
