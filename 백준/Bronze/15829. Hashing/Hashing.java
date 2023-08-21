
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num= sc.nextInt();
		String str=sc.next();
		int ans=0;
		for(int i=0;i<num;i++) {
			ans+=(str.charAt(i)-96)*Math.pow(31,i );
		}
		System.out.println(ans);
	}

}
