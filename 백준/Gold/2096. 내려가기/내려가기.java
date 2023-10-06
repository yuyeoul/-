import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int[]dpMax=new int[3];
		int[]dpMin=new int[3];
		
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			if(i==0) {
				dpMax[0]=dpMin[0]=a;
				dpMax[1]=dpMin[1]=b;
				dpMax[2]=dpMin[2]=c;
			}else {
				int dpM0=dpMax[0];
				int dpM1=dpMax[1];
				int dpM2=dpMax[2];
				dpMax[0]=Math.max(dpMax[0], dpMax[1])+a;
				dpMax[1]=Math.max(Math.max(dpM0, dpMax[1]), dpMax[2])+b;
				dpMax[2]=Math.max(dpM1, dpMax[2])+c;
				
				int dpMi0=dpMin[0];
				int dpMi1=dpMin[1];
				int dpMi2=dpMin[2];
				dpMin[0]=Math.min(dpMin[0], dpMin[1])+a;
				dpMin[1]=Math.min(Math.min(dpMi0, dpMin[1]), dpMin[2])+b;
				dpMin[2]=Math.min(dpMi1, dpMin[2])+c;
			}
		}
		int max=Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
		int min=Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
		System.out.println(max+" "+min);
	}

}
