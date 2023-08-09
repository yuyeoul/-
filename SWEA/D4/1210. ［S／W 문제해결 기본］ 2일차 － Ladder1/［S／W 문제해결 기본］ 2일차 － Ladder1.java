import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			// 100*100배열 생성
			int num = sc.nextInt();
			//사다리 저장할 배열
			int arr[][] = new int[100][100];
			//방문한 지점을 저장할 배열
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
			//초기지점 방문
			invite[r][c] = 1;
			while (true) {
				//가로진행 방향
				int dir = 0;
				//스타트 지점이 맨 왼쪽일때
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
				} else if (c == 99) {//스타트지점이 맨 오른쪽일 때
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
					//그 이외
				} else if ((c - 1 >= 0 && c + 1 < 100)) {//배열의 처음과 마지막 범위
					//arr[r][c]의 좌우가 0이면 위로 이동
					if (arr[r][c - 1] == 0 && arr[r][c + 1] == 0) {
						r -= 1;
						invite[r][c] = 1;
						//arr[r][c]의 좌우가 1이면 가로로 이동
					} else if (arr[r][c - 1] == 1 && arr[r][c + 1] == 1) {
						//왼쪽을 방문 했으면 오른쪽으로 이동
						if (invite[r][c - 1] == 1) {
							dir = 1;
							c += dir;
							invite[r][c] = 1;
						//오른쪽을 방문했으면 왼쪽으로 이동
						} else if (invite[r][c + 1] == 1) {
							dir = -1;
							c += dir;
							invite[r][c] = 1;
						}
						//상승하다가 갈림길 접하면 가로이동 or 가로이동하다가 끝나면 상승
					} else if ((arr[r][c - 1] == 0 && arr[r][c + 1] == 1)
							|| (arr[r][c + 1] == 0 && arr[r][c - 1] == 1)) {
						//왼쪽이 0이면 오른쪽이동
						if (arr[r][c - 1] == 0 && arr[r][c + 1] == 1) {
							//갈림길이 끝나는 지점이면 위로 상승
							if (invite[r][c + 1] == 1) {
								r -= 1;
								invite[r][c] = 1;
								//갈림길 시작점이면 가로이동
							} else {
								dir = 1;
								c += dir;
								invite[r][c] = 1;
							}
							//오른쪽이 0이면 왼쪽이동
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
				//시작지점 도달하면 끝
				if (r == 0) {
					break;
				}
			}
			System.out.println("#" + num + " " + c);

		}

	}

}