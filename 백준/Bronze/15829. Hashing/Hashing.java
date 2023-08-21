import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int num= sc.nextInt();
		String str=sc.next();
		Long ans=0L;
		int mod= 1234567891;
		for(int i=0;i<num;i++) {
			Long sca=(long) (str.charAt(i)-96);
			Long pow=(long) Math.pow(31,i );
			ans+= sca*pow%mod;
		}
		System.out.println(ans%mod);
	}

}