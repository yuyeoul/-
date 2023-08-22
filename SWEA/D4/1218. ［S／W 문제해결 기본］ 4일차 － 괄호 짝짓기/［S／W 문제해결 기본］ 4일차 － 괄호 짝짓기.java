import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//continue 지점 설정
		test: for (int tc = 1; tc <= 10; tc++) {
			//문자열 길이
			int len = sc.nextInt();
			//문자열 배열에 담기
			String str[] = sc.next().split("");
			//왼쪽 괄호 담아줄 list
			List<String> lList = new ArrayList<>();
			//길이가 홀수면 애초에 불가능
			if (len % 2 != 0) {
				System.out.println("#" + tc + " 0");
				continue;
			}
			//배열 돌면서 왼쪽 괄호면 리스트에 추가
			for (int i = 0; i < len; i++) {
				if (str[i].equals("(") || str[i].equals("{") || str[i].equals("[") || str[i].equals("<")) {
					lList.add(str[i]);
				//아니라면 비교 후 짝이 맞으면 리스트에서 짝 제거 or continue로 다음 문자열 넘어가기
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
