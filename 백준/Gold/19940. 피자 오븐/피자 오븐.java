import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int tc = 1; tc <= n; tc++) {
			int num = sc.nextInt();
			int a = num / 60;
			int b=0;
			int c=0;
			int d=0;
			int e=0;
			if (num % 60 == 0) {
				System.out.println(a + " 0 0 0 0");
			} else {
				
				num = num - 60 * (num / 60);
				if (num > 35) {
					a++;
					if (num % 10 < 5) {
						c=6-(num/10);
						d=num-(num/10*10);
					} else {
						c=6-(num/10)-1;
						e=60-(c*10)-num;
					}
				} else if(num>=10){
					if (num % 10 <= 5) {
						b=(num/10);
						d=num-(num/10*10);
					} 
					else {
						b=(num/10)+1;
						e=b*10-num;
					}
				}else {
					if (num % 10 <= 5) {
						d=num;
					} else {
						b=1;
						e=10-num;
					}
				}
				System.out.println(a+" "+b+" "+c+" "+d+" "+e+" ");
			}
		}
	}

}
