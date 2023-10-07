import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int len=sc.nextInt();
		String str = sc.next();
		
		int ans=0;
		List<Integer> list =new ArrayList<>();
		for(int i=0;i<len;i++) {
			int cnt=0;
			if(str.charAt(i)=='I') {
				while(true) {
					if(i+2<len && str.charAt(i+1)=='O'&&str.charAt(i+2)=='I') {
						cnt++;
						i+=2;
					}else {
						break;
					}
				}
			}
			if(cnt!=0) {
				list.add(cnt);
			}
			
		}
		for(int i=0;i<list.size();i++) {
			int cnt=(list.get(i)+1)-N;
			if(cnt>0) {
				ans+=cnt;
			}
		}
		System.out.println(ans);
	}

}
