import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <=num; i++) {
			queue.add(i);
		}

		for (int i = 1; i < num; i++) {
			queue.poll();
			queue.add(queue.poll());
			

		}
		System.out.println(queue.peek());

	}

}