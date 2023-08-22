import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테케 개수
		int num=sc.nextInt();
		for(int tc=1;tc<=num;tc++) {
			//숫자 개수
			int N=sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				int S=sc.nextInt();
				if(S!=0) {
					list.add(S);
				}else {
					list.remove(list.size()-1);
				}
			}
			int sum=0;
			for(int i=0;i<list.size();i++) {
				sum+=list.get(i);
			}
			System.out.println("#"+tc+" "+sum);
			
			
		}
	}

}
