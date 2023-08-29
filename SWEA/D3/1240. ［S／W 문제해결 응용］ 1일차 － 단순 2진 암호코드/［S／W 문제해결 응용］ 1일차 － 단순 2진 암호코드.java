import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans[] = { 13, 25, 19, 61,35, 49, 47, 59, 55, 11 };
			int N = sc.nextInt();
			int M = sc.nextInt();
			String map[][] = new String[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().split("");
			}
			int x = 0;
			int y = 0;
			boolean tf = false;
			int arr[] = new int[56];
			for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if (map[i][j].equals("1")) {
						x = i;
						y = j;
						tf = true;
						break;
					}
				}
				if (tf == true) {
					break;
				}
			}
			int idx = 0;
			for (int i = y - 55; i <= y; i++) {
				arr[idx] = Integer.parseInt(map[x][i]);
				idx++;
			}
			int pass[] = new int[9];

			int cnt = 0;
			int pow = 6;
			int idx1=1;
			for (int i = 0; i < 56; i++) {
				if(arr[i]==1) {
					cnt += Math.pow(2, pow);
				}
				pow--;
				if (pow < 0) {
					for(int j=0;j<ans.length;j++) {
						if(cnt==ans[j]) {
							pass[idx1] = j;
						}
					}
					pow=6;
					cnt=0;
					idx1++;
				}
			}
			int odd=0;
			int sum=0;
			for(int i=1;i<9;i++) {
				if(i%2!=0) {
					odd+=pass[i];
				}else {
					sum+=pass[i];
				}
			}
			sum+=odd*3;
			if(sum%10==0) {
				sum=0;
				for(int i=1;i<9;i++) {
					sum+=pass[i];
				}
				System.out.println("#"+tc+" "+sum);
			}else {
				System.out.println("#"+tc+" 0");
			}
		}

	}

}
