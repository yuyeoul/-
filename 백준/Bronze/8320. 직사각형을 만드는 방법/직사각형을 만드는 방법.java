import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		int cnt=0;
		int sum=0;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					cnt++;
				}
			}
			if(cnt%2==0) {
				sum+=cnt/2;
				cnt=0;
			}else {
				sum+=(cnt+1)/2;
				cnt=0;
			}
		}
		System.out.println(sum);

	}

}
