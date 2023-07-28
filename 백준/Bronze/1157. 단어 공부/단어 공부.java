import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] arr = str.toUpperCase().split("");
		Arrays.sort(arr);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1 && !arr[i].equals(arr[i + 1])) {
				list.add(Integer.toString(i));
			} else if (i == arr.length - 1) {
				list.add(Integer.toString(i));
			}
		}
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				list2.add(Integer.parseInt(list.get(0)) + 1);
			} else {
				list2.add(Integer.parseInt(list.get(i)) - Integer.parseInt(list.get(i - 1)));
			}
		}
		List<Integer> list3 = new ArrayList<>(list2);
		Collections.sort(list3);
		if (list3.size() > 1 && Integer.toString(list3.get(list3.size() - 1)).equals(Integer.toString(list3.get(list3.size() - 2))) ) {
			System.out.println("?");
		} else {
			for (int i = 0; i < list2.size(); i++) {
				if (list2.get(i) == list3.get(list3.size() - 1)) {
					System.out.println(arr[Integer.parseInt(list.get(i))]);
				}
			}
		}
		
	}

//		
}