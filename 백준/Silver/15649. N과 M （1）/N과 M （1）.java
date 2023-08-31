import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int select[] = new int[M];
		boolean[] used = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		perm(0, N, M, arr, select,used);
	}

	public static void perm(int idx, int N, int M, int arr[], int select[], boolean[] used) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				select[idx] = arr[i];
				perm(idx + 1, N, M, arr, select, used);
				used[i] = false;
			}
		}
	}

}
