import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr=new int[10];
		int num=sc.nextInt()*sc.nextInt()*sc.nextInt();
		String[] nuar=Integer.toString(num).split("");
		for(int i=0;i<nuar.length;i++) {
			for(int j=0;j<10;j++) {
				if(Integer.parseInt(nuar[i])==j) {
					arr[j]++;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}