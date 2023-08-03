import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int a = sc.nextInt();

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> nlist = new ArrayList<Integer>();

		for (int i = 1; i <= num; i++) {
			list.add(i);
		}
		while (true) {
			if(num==1&&a==1) {
				nlist.add(list.get(0));
				break;
			}else {
			Collections.rotate(list, -(a - 1));
			nlist.add(list.get(0));
			list.remove(0);
			if (list.size() == 1) {
				nlist.add(list.get(0));
				break;
			}
		}
		}
		System.out.print("<");
		for (int i = 0; i < nlist.size(); i++) {
			if (i <= nlist.size() - 2) {
				System.out.print(nlist.get(i) + ", ");
			} else {
				System.out.print(nlist.get(i) + ">");
			}

		}
	}
}