import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int num=sc.nextInt();
			//100*100 배열 생성
			int[][]arr =new int [100][100];
			//배열 채워넣기
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			//각 줄의 합을 담을 리스트 생성
			List<Integer> list =new ArrayList<>();
			//가로줄 합
			for(int i=0;i<100;i++) {
				int sum=0;
				for(int j=0;j<100;j++) {
					sum+=arr[i][j];
				}
				list.add(sum);
			}
			//세로줄 합
			for(int i=0;i<100;i++) {
				int sum=0;
				for(int j=0;j<100;j++) {
					sum+=arr[j][i];
				}
				list.add(sum);
			}
			//정 대각선 합
			int sum1=0;
			for(int i=0;i<100;i++) {
				sum1+=arr[i][i];
			}
			list.add(sum1);
			//역 대각선 합
			int sum2=0;
			for(int i=99;i>=0;i--) {
				sum2+=arr[99-i][i];
			}
			list.add(sum2);
			//리스트 정렬
			Collections.sort(list);
			
			//리스트 맨 끝값 출력
			System.out.println("#"+tc+" "+list.get(list.size()-1));
			
		}

	}

}