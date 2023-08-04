import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][]arr=new int[1001][1001];
		Scanner sc = new Scanner(System.in);
		int num= sc.nextInt();
		for(int i=0;i<num;i++) {
			int[] ia=new int[4];
			for(int j=0;j<4;j++) {
			ia[j]=sc.nextInt();
			}
			
			for(int j=ia[0];j<ia[0]+ia[2];j++) {
				for(int k=ia[1];k<ia[1]+ia[3];k++) {
					arr[j][k]=(i+1);
				}
			}
			
		}
		int[]sum=new int[num+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				sum[arr[i][j]]++;
			}
		}
		for(int i=1;i<sum.length;i++) {
			System.out.println(sum[i]);
		}

	}

}