import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[10];
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<10;i++) {
			arr[i]=sc.nextInt()%42;
			set.add(arr[i]);
		}
		//System.out.println(list.get(9));
		
		System.out.println(set.size());
		
		
		
}
}