import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테케 개수
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			//수열길이
			int N=sc.nextInt();
			//수열의 합
			int K=sc.nextInt();
			//수열 배열 생성 및 저장
			int arr[]=new int [N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			//출력 값 정답 변수
			int ans=0;
			//비트마스킹 사용
			//1을 N번 밀면 조합의 총 개수
			//2^N -1개
			for(int i=0;i<(1<<N);i++) {
				//수열 부분집합 합 저장 변수
				int sum=0;
				//수열 배열을 돌면서 1을 j번 밀어 만든 2진수가 i와 &연산한 값이 0보다 크다면 sum에 값 저장
				for(int j=0;j<N;j++) {
					if((i&(1<<j))>0) {
						sum+=arr[j];
					}
				}
				//부분집합 합이 주어진 값 K와 같다면 정답값 ++
				if(sum==K) {
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}

}
