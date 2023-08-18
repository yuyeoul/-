
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] mon = new int[num * 2];
		int[] day = new int[num * 2];
		for (int i = 0; i < num * 2; i++) {
			mon[i] = sc.nextInt();
			day[i] = sc.nextInt();
		}
		int tc=0;
		for (int i = 0; i < mon.length; i += 2) {
			tc++;
			int ans = 0;
			if (mon[i] == mon[i + 1]) {
				ans = day[i + 1] - day[i] + 1;
			} else {
				for (int j = mon[i]; j <= mon[i + 1]; j++) {
					if (j == mon[i]) {
						if (j == 2) {
							ans+=28-day[i];
						} else if (j == 4 || j == 6 || j == 9 || j == 11) {
							ans+=30-day[i];
						} else {
							ans+=31-day[i];
						}
					} else if (j == mon[i + 1]) {
						if (j == 2) {
							ans+=day[i+1]+1;
						} else if (j == 4 || j == 6 || j == 9 || j == 11) {
							ans+=day[i+1]+1;
						} else {
							ans+=day[i+1]+1;
						}
					} else {
						if (j == 2) {
							ans+=28;
						} else if (j == 4 || j == 6 || j == 9 || j == 11) {
							ans+=30;
						} else {
							ans+=31;
						}
					}
				}

			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}