import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int pa = sc.nextInt();
		sc.nextLine();
		Queue<String> ans = new LinkedList<>();
		List<Queue<String>> list = new LinkedList<>();
		for (int i = 0; i < pa; i++) {
			Queue<String> que = new LinkedList<>();
			String str[] = sc.nextLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				que.add(str[j]);
			}
			list.add(i, que);
		}
		String ansstr[] = sc.nextLine().split(" ");
		for (int i = 0; i < ansstr.length; i++) {
			ans.add(ansstr[i]);
		}
		boolean tf = false;
		int size=ans.size();
		int sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).size();
		}
		if(size!=sum) {
			System.out.println("Impossible");
		}else {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < pa; j++) {
					if (list.get(j).size()!=0 && list.get(j).peek().equals(ans.peek())) {
						tf = true;
						list.get(j).remove();
						ans.remove();
						break;
					}else {
						tf=false;
					}
				}
				if (tf == false) {
					System.out.println("Impossible");
					break;
				}

				if (ans.size() == 0) {
					System.out.println("Possible");
					break;
				}

			}
		}
		

	}

}
