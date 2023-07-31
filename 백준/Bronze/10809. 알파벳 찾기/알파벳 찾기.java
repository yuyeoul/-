import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int[] arr=new int[26];
		for(int i=0;i<arr.length;i++) {
			arr[i]=-1;
		}
		int index=0;
		for(int i=0;i<str.length();i++) {
			int n=str.charAt(i)-97;
			if(arr[n]==-1) {
				arr[n]=index;
				index++;
			}else {
				index++;
			}
			
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
