import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str= sc.nextLine();
		String[] arr= str.split(" ");
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=Integer.parseInt(arr[i])*Integer.parseInt(arr[i]);
		}
		System.out.println(sum%10);
	}

}
