import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//몇째줄에 있는가
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int start=1;
		int sum=1;
		int a=0;
		while(true) {
			a+=6;
			sum+=a;
			start++;
            if(num==1) {
				System.out.println(num);
				break;
			}
			if(sum>=num) {
				System.out.println(start);
				break;
			}
		}

	}

}
