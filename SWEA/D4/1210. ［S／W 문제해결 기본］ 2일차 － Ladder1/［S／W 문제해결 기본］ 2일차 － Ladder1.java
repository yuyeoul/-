import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			// 100*100배열 생성
			int num = sc.nextInt();
			int arr[][] = new int[100][100];
			int invite[][] = new int[100][100];
			int r = 99;
			int c = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 마지막 줄에서 값이 2인 인덱스 찾아서 저장=>출발지점
			for (int i = 0; i < 100; i++) {
				if (arr[r][i] == 2) {
					c = i;
				}
			}
			
			invite[r][c] = 1;
			while (true) {
				int dir = 0;
				if (c == 0) {
					if (arr[r][c + 1] == 0) {
						r -= 1;
						invite[r][c] = 1;
					} else {
						if(invite[r][c+1]==1) {
							r-=1;
							invite[r][c] = 1;
						}else {
						c += 1;
						invite[r][c] = 1;}
					}
				} else if (c == 99) {
					if (arr[r][c - 1] == 0) {
						r -= 1;
						invite[r][c] = 1;
					} else {
						if(invite[r][c-1]==1) {
							r-=1;
							invite[r][c] = 1;
						}else {
						c -= 1;
						invite[r][c] = 1;
						}
					}
				} else if ((c - 1 >= 0 && c + 1 < 100)) {
					if (arr[r][c - 1] == 0 && arr[r][c + 1] == 0) {
						r -= 1;
						invite[r][c] = 1;

					} else if (arr[r][c - 1] == 1 && arr[r][c + 1] == 1) {
						if (invite[r][c - 1] == 1) {
							dir = 1;
							c += dir;
							invite[r][c] = 1;
						} else if (invite[r][c + 1] == 1) {
							dir = -1;
							c += dir;
							invite[r][c] = 1;
						}
					} else if ((arr[r][c - 1] == 0 && arr[r][c + 1] == 1)
							|| (arr[r][c + 1] == 0 && arr[r][c - 1] == 1)) {
						if (arr[r][c - 1] == 0 && arr[r][c + 1] == 1) {
							if (invite[r][c + 1] == 1) {
								r -= 1;
								invite[r][c] = 1;
							} else {
								dir = 1;
								c += dir;
								invite[r][c] = 1;
							}
						} else if (arr[r][c + 1] == 0 && arr[r][c - 1] == 1) {
							if (invite[r][c - 1] == 1) {
								r -= 1;
								invite[r][c] = 1;
							} else {
								dir = -1;
								c += dir;
								invite[r][c] = 1;
							}
						}
					}
				}
				if (r == 0) {
					break;
				}
			}
			System.out.println("#" + num + " " + c);

		}

	}

}