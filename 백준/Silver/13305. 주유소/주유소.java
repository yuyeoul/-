import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		long cost[]=new long [N-1];
		long city[]=new long [N];
		int min=Integer.MAX_VALUE;
		int mini=0;
		for(int i=0;i<N-1;i++) {
			cost[i]=sc.nextInt();
		}
		for(int i=0;i<N-1;i++) {
			city[i]=sc.nextInt();
			if(city[i]<min) {
				min=(int) city[i];
				mini=i;
			}
		}
		long ans=0;
		for(int i=0;i<mini;) {
			if(city[i]>city[i+1]) {
				ans+=cost[i]*city[i];
				i++;
			}else {
				long c=city[i];
				long cnt=0;
				while(true) {
					cnt+=cost[i];
					i++;
					if(city[i]<=c) {
						break;
					}
				}
				ans+=c*cnt;
			}
		}
		long cnt=0;
		for(int i=mini;i<N-1;i++) {
			cnt+=cost[i];
		}
		ans+=min*cnt;
		System.out.println(ans);
		
		
	}

}
