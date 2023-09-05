import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int len=sc.nextInt();
		String str = sc.next();
		String p="IOI";
		for(int i=0;i<N-1;i++) {
			p+="OI";
		}
		int start=0;
		int cnt=0;
		for(int i=start;i<len;i++) {
			String ans="";
			if(str.charAt(i)=='I') {
				for(int j=i;j<=i+p.length()-1;j++) {
					if(j>=len) {
						break;
					}
					ans+=str.charAt(j);
				}
			}
			if(ans.equals(p)) {
				cnt++;
			}
			start=i;
		}
		System.out.println(cnt);
	}

}
