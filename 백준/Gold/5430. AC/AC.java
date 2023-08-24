import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= num; tc++) {
			// 실행 함수 담을 arr
			String arr[] = bf.readLine().split("");
			List<Integer> dlist = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("D")) {
					dlist.add(i);
				}
			}
			// 배열의 길이
			int len = Integer.parseInt(bf.readLine());

			// 배열을 담을 리스트
			Deque<Integer> list = new LinkedList<Integer>();

			// 수의 개수 0개라면
			if (len == 0) {
				String str = bf.readLine();
				// 실행함수에 D가 없으면 그대로 출력
				if (dlist.size() == 0) {
					bw.write(str+"\n");
					// D가 있다면 error
				} else {
					bw.write("error"+"\n");
				}
				// 한 개라면
			} else if (len == 1) {
				String str = bf.readLine();
				String str1 = "";
				for (int i = 1; i < str.length() - 1; i++) {
					str1 += str.charAt(i);
				}
				list.add(Integer.parseInt(str1));
				// 실행 함수 D가 1개보다 많다면 error
				if (dlist.size() > 1) {
					bw.write("error"+"\n");
				} else {
					// 아니라면 실행함수 실행
					if (dlist.size() == 1) {
						list.remove();
					}
					bw.write(list+"\n");
				}
				// 그 이상이라면
			} else {
				String str = bf.readLine();
				String arr2[] = str.substring(1, str.length() - 1).split(",");
				for (int i = 0; i < arr2.length; i++) {
					list.add(Integer.parseInt(arr2[i]));
				}
				//R의 상태
				//뒤에서 뺄지 앞에서 뺄지 정해줘야함
				int flag = 1;
				boolean tf = true;
				// 실행 함수 D의 개수가 숫자의 수보다 많다면 error
				if (dlist.size() > list.size()) {
					bw.write("error"+"\n");
				} else {
					for (int i = 0; i < arr.length; i++) {
						//list안에 아무것도 없는데 D가 나온다면
						if (list.size() == 0 && arr[i].equals("D")) {
							tf = false;
							break;
						}
						if (arr[i].equals("D")) {
							if (flag == 1) {
								list.remove();
							} else {
								list.removeLast();
							}
						} else {
							flag *= -1;
						}
					}

					if (tf == true) {
						if (list.size() == 0) {
							bw.write(list+"\n");
						} else {
							if (flag == 1) {
								bw.write("[");
								while(list.size()>1) {
									bw.write(list.poll() + ",");
								}
								bw.write(list.peek() + "]\n");
							} else {
								bw.write("[");
								while(list.size()>1) {
									bw.write(list.pollLast() + ",");
								}
								bw.write(list.peekLast() + "]\n");
							}
						}
					} else {
						bw.write("error"+"\n");
					}
				}
			}

		}
		bw.flush();
		bw.close();
	}
}
