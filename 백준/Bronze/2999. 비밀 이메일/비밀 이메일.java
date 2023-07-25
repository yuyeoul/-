import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int cnt =0 ;
		for(int i=1;i<=str.length();i++) {
			if(str.length()%i==0) {
				cnt++;
			}
		}
		int arr1[]=new int[cnt];
		int arr2[]=new int[cnt];
		int index=0;
		for(int i=1; i<=str.length();i++) {
			if(str.length()%i==0) {
				arr1[index]=i;
				arr2[index]=str.length()/i;
				index++;
			}
		}
		int x=0;
		int y=0;
		if(cnt%2==0) {
			x=arr1[(cnt/2)-1];
			y=arr2[(cnt/2)-1];
		}else {
			x=arr1[((cnt+1)/2)-1];
			y=arr2[((cnt+1)/2)-1];
		}
		String[] strar=str.split("");
		String ans="";
		for(int i=0;i<x;i++) {
			for(int j=0; j<y;j++) {
				ans+=strar[i+j*x];
			}
		}
		System.out.println(ans);
	}

}