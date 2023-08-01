import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		int sum = sc.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i<num;i++) {
			arr[i]=sc.nextInt();
		}
		int sum1=0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<num-2;i++) {
			for(int j=i+1;j<num-1;j++) {
				for(int k=j+1;k<num;k++) {
					sum1+=arr[i];
					sum1+=arr[j];
					sum1+=arr[k];
					if(sum1<=sum) {
						list.add(sum1);
						sum1=0;
					}else {
						sum1=0;
					}
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));

	}

}
