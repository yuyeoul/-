import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num= sc.nextInt();
			if(num==0) {
				break;
			}
			int sel[]=new int [6];
			int arr[]=new int [num];
			for(int i=0;i<num;i++) {
				arr[i]=sc.nextInt();
			}
			combi(0, 0, num, arr,sel);
			System.out.println();
		}
		

	}
	public static void combi(int in,int idx,int num,int arr[],int sel[]) {
		//기저파트
		if(idx==6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=in;i<=num-6+idx;i++) {
			sel[idx]=arr[i];
			combi(i+1,idx+1, num, arr,sel);
		}
	}

}
