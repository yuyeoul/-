import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T= sc.nextInt();
		int sum=0;
		String str= sc.next();
		String[] sar= new String[T];
		sar=str.split("");
		for(int i=0;i<T;i++) {
			if(sar[i].equals("L")) {
				sum+=1;
			}
		}
		if(sum==0) {
			System.out.println(T);
		}else {
			System.out.println(T-((sum/2)-1));
		}
	}
}
