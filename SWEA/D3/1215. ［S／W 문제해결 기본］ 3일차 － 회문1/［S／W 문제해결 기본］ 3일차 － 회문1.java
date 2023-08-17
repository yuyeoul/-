import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			// 회문 길이
			int num = sc.nextInt();
			// 회문 길이 1이면 종료
			if (num == 1) {
				System.out.println("#" + tc + " " + 64);
				break;
			}
			// 글자판 생성
			String map[][] = new String[8][8];
			// 글자판 저장
			for (int i = 0; i < 8; i++) {
				map[i] = sc.next().split("");
			}
			int mid=0;
			// 회문길이 짝수일때 중간값
			if(num%2==0) {
				mid=(num/2);
			// 홀수일때 중간값
			}else {
				mid=((num-1)/2);
			}
			//회문 개수 저장할 변수
			int ans=0;
			//가로축 회문탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - num; j++) {
					//대칭되는 인덱스 값 설정
					int index=j+num-1;
					//회문인지 아닌지 판별할 변수 값
					int cnt=0;
					for (int k = j; k < j + mid; k++) {
						if (map[i][k].equals(map[i][index--])) {
							cnt++;
						}
						//cnt가 mid값과 같다면 회문
						if(cnt==mid) {
							ans++;
						}
					}
				}
			}
			//세로축 회문탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - num; j++) {
					int index=j+num-1;
					int cnt=0;
					for (int k = j; k < j + mid; k++) {
						if (map[k][i].equals(map[index--][i])) {
							cnt++;
						}
						if(cnt==mid) {
							ans++;
						}
					}
				}
			}

			System.out.println("#"+tc+" "+ans);
		}
	}
}
