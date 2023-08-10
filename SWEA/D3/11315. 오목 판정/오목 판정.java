import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//반복횟수
		int num = sc.nextInt();
		for (int tc = 1; tc <= num; tc++) {
			//바둑판의 한변 길이
			int N = sc.nextInt();
			//바둑판 행렬 만들고
			String map[][] = new String[N][N];
			//받아온 값 집어 넣어주기
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().split("");
			}

			if (tfConfirm(map) == true) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}

		}
	}
	
	//true false 메소드
	public static boolean tfConfirm(String[][] map) {
		int nr = 0;
		int nc = 0;
		int N = map.length;
		// 우,하,우하대각,좌하대각 비교 델타
		int[] dr = { 0, 1, 1, 1 };
		int[] dc = { 1, 0, 1, -1 };
		//초기값 false
		boolean tf = false;
		//map의 행렬을 돌면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//만약 map[i][j]가 o라면
				if (map[i][j].equals("o")) {
					//델타 탐색을 하기위해 for문 작성
					for (int k = 0; k < 4; k++) {
						//처음 o를 찾아서 한개를 확보했고 델타탐색을 통해 연속해서 4번이 나와야 오목이므로
						//4번 반복하게 만들어줌
						for (int l = 1; l < 5; l++) {
							nr = i + dr[k] * l;
							nc = j + dc[k] * l;
							//0~N의 범위에서 벗어나면 탈출
							if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
								break;
							//4번 안에 .이나오면 오목이 불가능하므로 탈출
							} else if (map[nr][nc].equals(".")) {
								break;
							}
							//만약 위에서 탈출하지 않고 4번 돌았으면 오목이므로 true로 변경
							if (l == 4) {
								tf = true;
							}
						}
					}
				}
			}
		}
		return tf;
	}

}
