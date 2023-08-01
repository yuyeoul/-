import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 여자0 남자1
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int max = sc.nextInt();
		List<Integer> male = new ArrayList<>();
		List<Integer> female = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			if (sc.nextInt() == 0) {
				female.add(sc.nextInt());
			} else {
				male.add(sc.nextInt());
			}
		}
		int fesum = 0;
		int feroom = 0;
		int masum = 0;
		int maroom = 0;
		Collections.sort(female);
		Collections.sort(male);

		for (int i = 0; i < female.size(); i++) {
			if (i < female.size() - 1 && female.get(i) == female.get(i + 1)) {
				fesum += 1;
				if (i == female.size() - 1 && female.get(female.size() - 1) == female.get(female.size())) {
					fesum += 1;
					if (fesum % max != 0) {
						feroom += (fesum / max) + 1;
					} else {
						feroom += (fesum / max);
					}
				}
			} else {
				fesum += 1;
				if (fesum % max != 0) {
					feroom += (fesum / max) + 1;
				} else if (fesum % max == 0) {
					feroom += (fesum / max);
				} else {
					feroom += 0;
				}
				fesum = 0;
			}
		}
		for (int i = 0; i < male.size(); i++) {
			if (i < male.size() - 1 && male.get(i) == male.get(i + 1)) {
				masum += 1;
				if (i == male.size() - 1 && male.get(male.size() - 1) == male.get(male.size())) {
					masum += 1;
					if (masum % max != 0) {
						maroom += (masum / max) + 1;
					} else {
						maroom += (masum / max);
					}
				}
			} else {
				masum += 1;
				if (masum % max != 0) {
					maroom += (masum / max) + 1;
				} else if (masum % max == 0) {
					maroom += (masum / max);
				} else {
					maroom += 0;
				}
				masum = 0;
			}
		}
		System.out.println(feroom + maroom);

	}
}