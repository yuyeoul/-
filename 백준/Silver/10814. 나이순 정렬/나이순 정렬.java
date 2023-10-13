import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
	

public class Main {
	static class info implements Comparable<info>{
		int age;
		String name;
		public info(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(info o) {
			// TODO Auto-generated method stub
			return age-o.age;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<info> list =new ArrayList<>();
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			String str=sc.next();
			list.add(new info(a, str));
		}
		Collections.sort(list);
		for(int i=0;i<N;i++) {
			System.out.println(list.get(i).age+" "+list.get(i).name);
		}
		
		}
	}

