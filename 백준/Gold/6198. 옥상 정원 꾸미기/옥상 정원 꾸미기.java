import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int arr[] = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> stack=new Stack<>();
		long sum = 0;
		for (int i = 0; i < num; i++) {
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			stack.push(arr[i]);
			sum+=stack.size()-1;
		}
		System.out.println(sum);
	}

}
