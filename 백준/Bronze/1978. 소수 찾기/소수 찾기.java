import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		int []arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=sc.nextInt();
		}
		int cnt=0;
		for(int i=0;i<arr.length;i++) {
			int cnt1=0;
			for(int j=1;j<=arr[i];j++) {
				if(arr[i]%j==0) {
					cnt1++;
				}
			}
			if(cnt1==2) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}