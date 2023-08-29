import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테케 개수
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			int cnt=0;
			while(true) {
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
