import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split("-");
		List<Integer> sumL=new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			int idx = 0;
			int sum = 0;
			boolean tf= false;
			List<String> list = new ArrayList<String>();
			for (int j = idx; j < str[i].length(); j++) {
				if (str[i].charAt(j) == '-' || str[i].charAt(j) == '+') {
					list.add(str[i].substring(idx, j));
					idx = j + 1;
					tf=true;
				}
			}
			list.add(str[i].substring(idx, str[i].length()));
			if(tf==false) {
				sum+=Integer.parseInt(str[i]);
			}else {
				for(int j=0;j<list.size();j++) {
					sum+=Integer.parseInt(list.get(j));
				}
			}
			sumL.add(sum);
		}
		int ans=sumL.get(0);
		if(sumL.size()==1) {
			System.out.println(ans);
		}else {
			for(int i=1;i<sumL.size();i++) {
				ans-=sumL.get(i);
			}
			System.out.println(ans);
		}
	}

}
