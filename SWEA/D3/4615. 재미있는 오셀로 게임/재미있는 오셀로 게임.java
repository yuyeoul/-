import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int tc = 1; tc <= num; tc++) {
			// 한 변 길이
			int len = sc.nextInt();
			// 돌 놓는 횟수
			int cnt = sc.nextInt();
			// 오셀로 판 생성
			int map[][] = new int[len][len];
			// 1 흑돌 2 백돌
			// 기본 돌 놓기
			map[(len / 2) - 1][(len / 2) - 1] = 2;
			map[len / 2][len / 2] = 2;
			map[len / 2][(len / 2) - 1] = 1;
			map[(len / 2) - 1][len / 2] = 1;

			// 델타 탐색 배열
			// 상하좌우 좌상 우상 좌하 우하
			int dc[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int dr[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
			for (int i = 0; i < cnt; i++) {
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				map[c][r] = sc.nextInt();
				int ncr = map[c][r];
				for (int j = 0; j < len; j++) {
					for (int k = 0; k < len; k++) {
						if (map[j][k] == ncr) {
							for (int l = 0; l < 8; l++) {
								int nc = c + dc[l];
								int nr = r + dr[l];
								if (nc >= 0 && nr >= 0 && nc < len && nr < len) {
									int cn = 1;
									if (map[nc][nr] != 0 && map[c][r] != map[nc][nr]) {
										while (true) {
											nc += dc[l];
											nr += dr[l];
											cn++;
											if (nc < 0 || nr < 0 || nc >= len || nr >= len||map[nc][nr]==0) {
												break;
											}
											
											if (map[nc][nr] == ncr) {
												int nnc = c;
												int nnr = r;
												for (int a = 1; a < cn; a++) {
													nnc += dc[l];
													nnr += dr[l];
													map[nnc][nnr] = ncr;
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			int B = 0;
			int W = 0;
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					if (map[j][k] == 1) {
						B++;
					} else if (map[j][k] == 2) {
						W++;
					}
				}
			}
			System.out.println("#" + tc + " " + B + " " + W);
		}
	}
}
