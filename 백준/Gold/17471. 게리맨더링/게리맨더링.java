import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	static Map<Integer, List<Integer>> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 지역구 
		int[] arr = new int[N];// 배열 선언 
		for(int i=0; i<N;i++) {// 값 넣
			arr[i]=sc.nextInt();
		}
		map = new TreeMap<>();// 연결정보 저장하는 
		
		for(int i=1;i<=N;i++) {// 연결정보 넣
			int n = sc.nextInt();
			map.put(i, new ArrayList<>());
			for(int j=0;j<n;j++) {
				map.get(i).add(sc.nextInt());
			}
		}
		int ans = 1000;
		for(int i=1;i<(1<<N);i++) {
			List<Integer> lista = new ArrayList<>();
			int valuea=0;
			List<Integer> listb = new ArrayList<>();
			int valueb=0;
			for(int j=0 ;j<N;j++) {
				if((i & (1<<j)) >0) {
					lista.add(j+1);
					valuea+=arr[j];
				}else {
					listb.add(j+1);
					valueb+=arr[j];
				}
			}
			if(Math.abs(valuea-valueb)<ans&&bfs(lista)&&bfs(listb)) {
//				System.out.println(lista);
//				System.out.println(listb);
//				System.out.println(valuea);
//				System.out.println(valueb);
				ans =Math.abs(valuea-valueb);
			}
		}
		if(ans == 1000) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	public static boolean bfs(List<Integer> list) {
		boolean[] visited = new boolean[map.size()+1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(list.get(0));
		visited[list.get(0)]=true;
		while(!queue.isEmpty()) {
			int key=queue.poll();
			for(int nextKey:map.get(key)) {
				if(!visited[nextKey]&&list.contains(nextKey)) {
					queue.add(nextKey);
					visited[nextKey]=true;
				}
			}
		}
		for(int i : list) {
			if(!visited[i]) {
				return false;
			}
		}
		
		return true;
		
		
	}
}
