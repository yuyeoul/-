import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=1;i<=num;i++) {
			int n =sc.nextInt();
			int[] xd= {1,0,-1,0};
			int[] yd= {0,1,0,-1};
			int[][] map=new int[n][n];
			int r=0;
			int c=0;
			int dir=0;
			//우0하1좌2상3
			int x=n-1;
			int y=0;
			for(int j=1;j<=n*n;j++) {
				map[r][c]=j;
				if(r==y&&c==x) {
					dir=1;
				}else if(r==x&&c==x) {
					dir=2;
				}else if(r==x&&c==y) {
					dir=3;
				}else if(r==y+1&&c==y) {
					dir=0;
					x-=1;
					y+=1;
				}
				r+=yd[dir];
				c+=xd[dir];
			}
            System.out.println("#"+i);
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					System.out.print(map[j][k]+" ");
				}
				System.out.println();
			}
			
		}
	}

}
