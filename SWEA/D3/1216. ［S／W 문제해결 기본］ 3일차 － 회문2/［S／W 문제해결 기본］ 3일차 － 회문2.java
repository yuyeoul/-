import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();

			String map[][] = new String[100][100];

			for (int i = 0; i < 100; i++) {
				map[i] = sc.next().split("");
			}
			int ans = 0;
			// 가로축
			for (int i = 0; i < 100; i++) {
				// 세로축
				for (int j = 0; j < 100; j++) {
					// 탐색할 회문의 길이 변화
					hi:for (int k = 1; k < 101 - j; k++) {
						//끝 인덱스 설정
						int index = j + k-1;
						//맨앞과 맨뒤부터 비교
						for (int l = j; l < j+(k/2); l++) {
							if (!map[i][l].equals(map[i][index--])) {
								continue hi;
							}
						}
						ans=Math.max(ans, k);
					}

				}

			}
			for (int j = 0; j < 100; j++) {
				// 세로축
				for (int i = 0; i < 100; i++) {
					// 탐색할 회문의 길이 변화
					bye:for (int k = 1; k < 101 - i; k++) {
						//끝 인덱스 설정
						int index = i + k -1;
						for (int l = i; l < i+(k/2); l++) {
							if (!map[l][j].equals(map[index--][j])) {
								continue bye;
							}

						}
						ans=Math.max(ans, k);

					}

				}
			}
			System.out.println("#"+tc+ " "+ans);
		}

	}

}
