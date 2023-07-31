import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			String str= sc.next();
			String[] arr= str.split("");
			int a=1;
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				if(j==0 && arr[j].equals("O")) {
					sum+=a;
					a++;
				}else if(arr[j].equals("O")&&arr[j-1].equals("O")) {
					sum+=a;
					a++;
				}else if(arr[j].equals("X")) {
					a=1;
				}else if(arr[j].equals("O")&& !arr[j-1].equals("O")) {
					sum+=a;
					a++;
				}
			}
			System.out.println(sum);
		}
		
		
		
		
}
}