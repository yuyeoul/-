import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		for(int tc=1;tc<=num;tc++) {
			int k=sc.nextInt();
			int n=sc.nextInt();
			int map[][]=new int [k+1][15];
			for(int i=1;i<15;i++) {
				map[0][i]=i;
			}
			for(int i=1;i<k+1;i++) {
				for(int j=1;j<15;j++) {
					int sum=0;
					for(int l=1;l<=j;l++) {
						sum+=map[i-1][l];
					}
					map[i][j]=sum;
				}
			}
			System.out.println(map[k][n]);
		}
	}

}