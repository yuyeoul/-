import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
	}

}