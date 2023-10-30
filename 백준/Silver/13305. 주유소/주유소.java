import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int cost[]=new int [N-1];
		int city[]=new int [N];
		int min=Integer.MAX_VALUE;
		int mini=0;
		for(int i=0;i<N-1;i++) {
			cost[i]=sc.nextInt();
		}
		for(int i=0;i<N-1;i++) {
			city[i]=sc.nextInt();
			if(city[i]<min) {
				min=city[i];
				mini=i;
			}
		}
		city[N-1]=sc.nextInt();
		int ans=0;
		for(int i=0;i<mini;) {
			if(city[i]>city[i+1]) {
				ans+=cost[i]*city[i];
				i++;
			}else {
				int c=city[i];
				int cnt=0;
				while(true) {
					cnt+=cost[i];
					i++;
					if(city[i]>city[i+1]) {
						break;
					}
				}
				ans+=c*cnt;
				System.out.println(ans);
			}
		}
		int cnt=0;
		for(int i=mini;i<N-1;i++) {
			cnt+=cost[i];
		}
		ans+=min*cnt;
		System.out.println(ans);
		
		
	}

}
