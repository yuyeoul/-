import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		int max=-1000000;
		int min=1000000;
		int[] arr =new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
		}
        System.out.println(min);
		System.out.println(max);
	}

}