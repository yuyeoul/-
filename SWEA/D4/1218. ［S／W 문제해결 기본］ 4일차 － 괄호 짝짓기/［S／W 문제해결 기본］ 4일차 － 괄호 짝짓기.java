import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test: for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String str[] = sc.next().split("");
			List<String> lList = new ArrayList<>();
			if (len % 2 != 0) {
				System.out.println("#" + tc + " 0");
				continue;
			}

			for (int i = 0; i < len; i++) {
				if (str[i].equals("(") || str[i].equals("{") || str[i].equals("[") || str[i].equals("<")) {
					lList.add(str[i]);
				} else {
					if(str[i].equals(")")) {
						if(lList.get(lList.size()-1).equals("(")){
							lList.remove(lList.size()-1);
						}else {
							System.out.println("#" + tc + " 0");
							continue test;
						}
					}else if(str[i].equals("}")) {
						if(lList.get(lList.size()-1).equals("{")){
							lList.remove(lList.size()-1);
						}else {
							System.out.println("#" + tc + " 0");
							continue test;
						}
					}else if(str[i].equals("]")) {
						if(lList.get(lList.size()-1).equals("[")){
							lList.remove(lList.size()-1);
						}else {
							System.out.println("#" + tc + " 0");
							continue test;
						}
					}else {
						if(lList.get(lList.size()-1).equals("<")){
							lList.remove(lList.size()-1);
						}else {
							System.out.println("#" + tc + " 0");
							continue test;
						}
					}
					
				}
			}
			
			System.out.println("#" + tc + " 1");

		}
	}

}
