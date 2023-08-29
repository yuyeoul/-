import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테케 개수
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			//연속되야하는 비트개수
			int N=sc.nextInt();
			//10진수
			int M=sc.nextInt();
			//연속되는 비트개수 누적 변수
			int cnt=0;
			while(true) {
				//십진수를 이진수로 만드는 방법->2로 나눠서 나머지를 기록한 다음에 역순으로 읽으면 된다
				//따라서 1이 연속으로 N번 나오면 당첨
				if(M%2==1) {
					M=M/2;
					cnt++;
				}else {
					break;
				}
				
				if(cnt==N) {
					break;
				}
				
			}
			if(cnt==N) {
				System.out.println("#"+tc+" ON");
			}else {
				System.out.println("#"+tc+" OFF");
			}
		}
	}
}
