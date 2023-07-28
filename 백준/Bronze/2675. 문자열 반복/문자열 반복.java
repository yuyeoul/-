import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		for(int i=0;i<num;i++) {
			int a= sc.nextInt();
			String str=sc.next();
			String[] arr = str.split("");
			String ns="";
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<a;k++) {
					ns+=arr[j];
				}
			}
			System.out.println(ns);
		}
	}

}