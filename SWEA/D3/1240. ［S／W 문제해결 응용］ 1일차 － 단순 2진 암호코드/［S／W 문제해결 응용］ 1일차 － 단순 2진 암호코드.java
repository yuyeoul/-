import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테케 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			//0~9를 인덱스로 잡고 주어진 배열의 2진수를 10진수로 바꿔서 저장
			int ans[] = { 13, 25, 19, 61, 35, 49, 47, 59, 55, 11 };
			//높이
			int N = sc.nextInt();
			//너비
			int M = sc.nextInt();
			//암호문 저장 배열 및 채우기
			String map[][] = new String[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().split("");
			}
			//1이 시작되는 지점 저장할 변수
			int x = 0;
			int y = 0;
			boolean tf = false;
			//암호문을 뽑아서 저장할 배열
			int arr[] = new int[56];
			//위에서 아래로, 뒤에서 앞으로 탐색
			//1만나면 x,y에 저장하고 종료
			for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if (map[i][j].equals("1")) {
						x = i;
						y = j;
						tf = true;
						break;
					}
				}
				if (tf == true) {
					break;
				}
			}
			//arr에 접근할 인덱스 변수
			int idx = 0;
			//arr에 암호문 채우기
			for (int i = y - 55; i <= y; i++) {
				arr[idx] = Integer.parseInt(map[x][i]);
				idx++;
			}
			//암호문 해독 저장 배열
			int pass[] = new int[9];
			//암호문 10진수로 변환 변수
			int cnt = 0;
			//제곱 수 변수
			int pow = 6;
			//pass배열에 접근할 인덱스 변수
			int idx1=1;
			//암호문 배열 돌면서 1이면 2진수 ->10진수로 변환
			for (int i = 0; i < 56; i++) {
				if(arr[i]==1) {
					cnt += Math.pow(2, pow);
				}
				pow--;
				//제곱수가 0보다 작아지면 최종 cnt를 ans 배열과 비교해서 같은 값의 인덱스를 pass 배열에 저장
				if (pow < 0) {
					for(int j=0;j<ans.length;j++) {
						if(cnt==ans[j]) {
							pass[idx1] = j;
						}
					}
					pow=6;
					cnt=0;
					idx1++;
				}
			}
			//홀수만 3배해주고 sum에 더하기
			//짝수는 바로 sum에 더하기
			int sum=0;
			for(int i=1;i<9;i++) {
				if(i%2!=0) {
					sum+=pass[i]*3;
				}else {
					sum+=pass[i];
				}
			}
			//암호문이 10의 배수면 각 자리 수 다 더해주고 아니라면 0출력
			if(sum%10==0) {
				sum=0;
				for(int i=1;i<9;i++) {
					sum+=pass[i];
				}
				System.out.println("#"+tc+" "+sum);
			}else {
				System.out.println("#"+tc+" 0");
			}
		}

	}

}
