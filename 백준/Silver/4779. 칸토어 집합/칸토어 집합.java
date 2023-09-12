import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			sb=new StringBuilder();
			int num=sc.nextInt();
			
			int N=(int) Math.pow(3, num);
			for(int i=0;i<N;i++) {
				sb.append("-");
			}
			dmdkr(0,N);
			System.out.println(sb);
		}
	}
	
	public static void dmdkr(int s,int N) {
		if(N==1) {
			return;
		}
		int newN=N/3;
		
		for(int i=s+newN;i<s+2*newN;i++) {
			sb.setCharAt(i, ' ');
		}
		
		 
		dmdkr(s,newN);
		dmdkr(s+2*newN,newN);
		
		
	}
}
