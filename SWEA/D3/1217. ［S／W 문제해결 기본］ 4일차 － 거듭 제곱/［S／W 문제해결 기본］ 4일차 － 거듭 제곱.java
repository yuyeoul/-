import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10개 테케
		for(int tc=1;tc<=10;tc++) {
			int T=sc.nextInt();
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			System.out.println("#"+tc+" "+pow(N, M));
		}
	}
	//재귀함수
	public static int pow(int N,int M) {
		//기저조건
		//지수가 1이면 종료
		if(M==1) {
			return N;
		}
		//재귀조건
		//지수가 짝수 홀수일 때 구분
		//ex) N=2 M=6
		//2^6==2^3*2^3....
		//2^3==2^1*2^1*2
		if(M%2==0) {
			return pow(N,M/2)*pow(N,M/2);
		}else {
			return pow(N,(M-1)/2)*pow(N,(M-1)/2)*N;
		}
	}
}
