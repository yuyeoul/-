import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int select[] = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		combi(0,0, N, M, arr, select);
		System.out.println(sb.toString());
	}

	public static void combi(int idx, int sidx,int N, int M, int arr[], int select[]) {
		//기저파트
				if(sidx==M) {
					for (int i = 0; i < M; i++) {
			            sb.append(select[i] + " ");
			        }
					sb.append("\n");
					return;
				}
				for(int i=idx;i<N;i++) {
					select[sidx]=arr[i];
					combi(i, sidx+1,N,M,arr,select);
				}
	}

}
