import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C, T;
	static int arr[][];
	static List<Integer> ar;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		arr = new int[R][C];
		ar = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == -1) {
					ar.add(i);
				}
			}
		}

		for (int t = 0; t < T; t++) {
			dust();
			ac();
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	public static void dust() {
		int[][] duarr = new int[R][C];
		int y1 = ar.get(0);
		int y2 = ar.get(1);
		duarr[y1][0] = -1;
		duarr[y2][0] = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					int num = arr[i][j];
					int div = num / 5;
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] != -1) {
							duarr[nr][nc] += div;
							cnt++;
						}
					}
					duarr[i][j] -= div * cnt;
				}
			}
		}
		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				arr[a][b] += duarr[a][b];
			}
		}
		arr[y1][0] = -1;
		arr[y2][0] = -1;
	}

	public static void ac() {
		int duarr[][] = new int[R][C];
		int y1 = ar.get(0);
		int y2 = ar.get(1);
		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				duarr[a][b] = arr[a][b];
			}
		}
		for (int i = 0; i <= y1; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0) {
					if (j + 1 < C) {
						duarr[i][j] = arr[i][j + 1];
					}
				}
				if (i == y1) {
					if (j == 1) {
						duarr[i][j] = 0;
					} else if (j > 1) {
						duarr[i][j] = arr[i][j - 1];
					}

				}
				if (j == 0) {
					if (i - 1 >= 0) {
						if (arr[i][j] != -1) {
							duarr[i][j] = arr[i - 1][j];
						} else {
							duarr[i][j] = -1;
						}
					}
				}
				if (j == C - 1) {
					if (i + 1 <= y1) {
						duarr[i][j] = arr[i + 1][j];
					}
				}

			}
		}

		
		for (int i = y2; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == y2) {
					if(j==1) {
						duarr[i][j]=0;
					}else if(j>1) {
						duarr[i][j]=arr[i][j-1];
					}
				} 
				if (i == R - 1) {
					if (j + 1 < C) {
						duarr[i][j] = arr[i][j + 1];
					}
				}
				if (j == 0) {
					if (i + 1 < R) {
						if (arr[i][j] != -1) {
							duarr[i][j] = arr[i+1][j];
						} else {
							duarr[i][j] = -1;
						}
					}
				} 
				if (j == C - 1) {
					if (i - 1 > y1) {
						duarr[i][j] = arr[i - 1][j];
					}
				}

			}
		}
		arr = duarr;
	}

}
