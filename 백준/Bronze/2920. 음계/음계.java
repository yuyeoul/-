import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inc= {1,2,3,4,5,6,7,8};
		int[] dec= {8,7,6,5,4,3,2,1};
		int[] arr =new int[8];
		for(int i=0;i<8;i++) {
			arr[i]=sc.nextInt();
		}
		if(Arrays.equals(inc, arr)) {
			System.out.println("ascending");
		}else if(Arrays.equals(dec, arr)) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
		
		
		
}
}