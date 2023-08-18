import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//월 저장 배열
		int[] mon = new int[num * 2];
		//일 저장 배열
		int[] day = new int[num * 2];
		//1~12월의 끝날 배열
		int[] dayArr= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		//월 일 저장
		for (int i = 0; i < num * 2; i++) {
			mon[i] = sc.nextInt();
			day[i] = sc.nextInt();
		}
		//출력번호 변수
		int tc=0;
		for (int i = 0; i < mon.length; i += 2) {
			tc++;
			//날짜 저장 변수
			int ans = 0;
			//첫 달과 마지막 달이 같으면 날짜 끼리 빼고 +1
			if (mon[i] == mon[i + 1]) {
				ans = day[i + 1] - day[i] + 1;
			//같지 않다면
			} else {
				
				for (int j = mon[i]; j <= mon[i + 1]; j++) {
					//첫 번째 달이라면 그 달의 마지막 요일에서 입력된 요일 차이 ans에 더하기
					if (j == mon[i]) {
						ans+=dayArr[j]-day[i]+1;
					//마지막 달이라면 그 달에 같이 입력된 요일  더하기 
					} else if (j == mon[i + 1]) {
						ans+=day[i+1];
					} else {
					//중간에 껴있는 달이라면 그 달의 전체 날짜 더하기
						ans+=dayArr[j];
					}
				}

			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}