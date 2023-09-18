import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int len=sc.nextInt();
		String str = sc.next();
		
		int start=0;
		int ans=0;
		for(int i=start;i<len;i++) {
			int cnt=0;
			if(str.charAt(i)=='I') {
				for(int j=i+1;j<=i+N*2;j+=2) {
					if(j+1<len && str.charAt(j)=='O'&&str.charAt(j+1)=='I') {
						cnt++;
					}else {
						break;
					}
					
				}
			}
			if(cnt==N) {
				ans++;
			}
			start=i;
		}
		System.out.println(ans);
	}

}
