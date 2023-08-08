import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int x = 3;
		int y = 5;

		int x_max = sum / x;

		List<Integer> xlist = new ArrayList<>();
		List<Integer> ylist = new ArrayList<>();
		List<Integer> sumlist= new ArrayList<>();
		for (int i = 0; i <= x_max; i++) {
			if ((sum - x * i) % y == 0) {
				xlist.add(i);
				ylist.add((sum - x * i) / y);
			}
		}
		for(int i=0;i<xlist.size();i++) {
			sumlist.add(xlist.get(i)+ylist.get(i));
		}
		if(sumlist.isEmpty()) {
			System.out.println(-1);
		}else {
			Collections.sort(sumlist);
			System.out.println(sumlist.get(0));
		}
	}
}