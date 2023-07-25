import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sum=0;
		int index=0;
		int[] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=sc.nextInt();
		}
		
			for(int i=0;i<10;i++) {
				sum+=arr[i];
				index=i;
				if(sum>100) {
					break;
				}
			}
		
		if(100-(sum-arr[index])>=sum-100) {
			System.out.println(sum);
		}else {
			System.out.println(sum-arr[index]);
		}
	}

}