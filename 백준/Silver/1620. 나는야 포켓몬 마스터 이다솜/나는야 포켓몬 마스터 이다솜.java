import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, String> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			map1.put(i,str);
			map2.put(str, i);
		}
		for(int i=0;i<M;i++) {
			boolean tf =true;
			String enst=br.readLine();
			for(int j=0;j<enst.length();j++) {
				if(!Character.isDigit(enst.charAt(j))) {
					tf=false;
					break;
				}
			}
			if(tf==true) {
				bw.write(map1.get(Integer.parseInt(enst))+"\n");
			}else {
				bw.write(map2.get(enst)+"\n");
			}
		}
		bw.flush();
		bw.close();

	}

}
