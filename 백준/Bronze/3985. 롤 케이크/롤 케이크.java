import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roll= sc.nextInt();
		int[] roar=new int[roll];
		int T=sc.nextInt();
		int[] st=new int[T];
		int[] en=new int[T];
		int max=0;
		int index=0;
		for(int i=0;i<T;i++) {
			st[i]=sc.nextInt();
			en[i]=sc.nextInt();
			if(max<en[i]-st[i]) {
				max=en[i]-st[i];
				index=i+1;
				if(i<T-1 && en[i]-st[i]==en[i+1]-st[i+1]) {
					index=i+1;
				}
			}
		}
		for(int i=0;i<T;i++) {
			for(int j=st[i];j<=en[i];j++) {
				if(roar[j-1]==0) {
					roar[j-1]=i+1;
				}
			}
		}
	
		System.out.println(index);
		int[] near=new int [T];
		for(int i=0;i<roll;i++) {
			if(roar[i]!=0) {
				near[roar[i]-1]+=1;
			}
		}
		int max1=0;
		int index1=0;
		for(int i=0;i<T;i++) {
			if(near[i]>max1) {
				max1=near[i];
				index1=i+1;
				if(i<T-1 && near[i]==near[i+1]) {
					index1=i+1;
				}
			}
		}
		System.out.println(index1);
	}

}
