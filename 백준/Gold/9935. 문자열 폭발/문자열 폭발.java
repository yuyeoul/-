import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.next();
		String bomb=sc.next();
		
		Stack<Character> s=new Stack<>();
		
		hi:for(int i=0;i<str.length();i++) {
			s.push(str.charAt(i));
			int cnt=0;
			if(s.size()>=bomb.length()) {
				for(int j=0;j<bomb.length();j++) {
					if(s.get(s.size()-bomb.length()+j)==bomb.charAt(j)) {
						cnt++;
					}else {
						continue hi;
					}
				}
			}
			if(cnt==bomb.length()) {
				for(int j=0;j<bomb.length();j++) {
					s.pop();
				}
			}
		}
		if(s.size()==0) {
			System.out.println("FRULA");
		}else {
			for(int i=0;i<s.size();i++) {
				sb.append(s.get(i));
			}
		}
		System.out.println(sb);

	}
}
