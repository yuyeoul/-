import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {

			String[] arr1 = sc.next().split("");
			String[] arr2 = sc.next().split("");
			String[] arr3 = sc.next().split("");
			String[] arr4 = sc.next().split("");
			String[] arr5 = sc.next().split("");

			String[] narr1 = new String[15];
			String[] narr2 = new String[15];
			String[] narr3 = new String[15];
			String[] narr4 = new String[15];
			String[] narr5 = new String[15];
			for (int j = 0; j < arr1.length; j++) {
				narr1[j] = arr1[j];
			}
			for (int j = 0; j < arr2.length; j++) {
				narr2[j] = arr2[j];
			}
			for (int j = 0; j < arr3.length; j++) {
				narr3[j] = arr3[j];
			}
			for (int j = 0; j < arr4.length; j++) {
				narr4[j] = arr4[j];
			}
			for (int j = 0; j < arr5.length; j++) {
				narr5[j] = arr5[j];
			}
			String str = "";
			for (int j = 0; j < 15; j++) {
				if (narr1[j] != null) {
					str += narr1[j];
				}
				if (narr2[j] != null) {
					str += narr2[j];
				} 
				if (narr3[j] != null) {
					str += narr3[j];
				} 
				if (narr4[j] != null) {
					str += narr4[j];
				} 
				if (narr5[j] != null) {
					str += narr5[j];
				} 
			}
			System.out.println("#"+(i+1)+" "+str);
		}
	}

}