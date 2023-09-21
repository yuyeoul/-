import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class info {
		int x, y;

		public info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			List<Integer> sx = new ArrayList<>();
			List<Integer> sy = new ArrayList<>();
			List<Integer> sv = new ArrayList<>();
			List<info> person = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int a = sc.nextInt();
					arr[i][j] = a;
					if (a == 1) {
						person.add(new info(i, j));
					}
					if (a > 1) {
						sx.add(i);
						sy.add(j);
						sv.add(a);
					}
				}
			}

			List<Integer> s1 = new ArrayList<>();
			List<Integer> s2 = new ArrayList<>();
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << person.size()); i++) {
				s1 = new ArrayList<>();
				s2 = new ArrayList<>();
				for (int j = 0; j < person.size(); j++) {
					if (((1 << j) & i) > 0) {
						s1.add(Math.abs(sx.get(0) - person.get(j).x) + Math.abs(sy.get(0) - person.get(j).y));
					} else {
						s2.add(Math.abs(sx.get(1) - person.get(j).x) + Math.abs(sy.get(1) - person.get(j).y));
					}
				}
				Collections.sort(s1);
				Collections.sort(s2);
				int max = 0;
				for (int k = 0; k < s1.size(); k++) {
					if (k < 3) {
						s1.set(k, s1.get(k) + sv.get(0)+1);
					} else {
						s1.set(k, Math.max(s1.get(k) + sv.get(0)+1, s1.get(k - 3) + sv.get(0)));
					}
				}
				for (int k = 0; k < s2.size(); k++) {
					if (k < 3) {
						s2.set(k, s2.get(k) + sv.get(1)+1);
					} else {
						s2.set(k, Math.max(s2.get(k) + sv.get(1)+1, s2.get(k - 3) + sv.get(1)));
					}
				}
				if(s1.size()==0) {
					max=s2.get(s2.size()-1);
				}else if(s2.size()==0) {
					max=s1.get(s1.size()-1);
				}else {
					max=Math.max(s1.get(s1.size()-1), s2.get(s2.size()-1));
				}
				if(max<ans) {
					ans=max;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}

	}

}
