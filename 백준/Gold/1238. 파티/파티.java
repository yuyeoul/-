import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		adjList = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjList[A].add(new Node(B, W));
		}
		int sum[]=new int[N+1];
		for(int i=1;i<N+1;i++) {
			dijkstra(i);
			
			if(i==X) {
				for(int j=1;j<N+1;j++) {
					sum[j]+=dist[j];
				}
			}else {
				sum[i]+=dist[X];
			}
			
		}
		int max=0;
		for(int i=1;i<N+1;i++) {
			if(sum[i]>max) {
				max=sum[i];
			}
		}
		System.out.println(max);
	}

	static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		for (int i = 1; i < N+1 ; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 1; j < N+1; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if (idx == -1) {
				break;
			}
			visited[idx] = true;

			for (int j = 0; j < adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);

				if (!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
				}
			}
		}
	}

}
