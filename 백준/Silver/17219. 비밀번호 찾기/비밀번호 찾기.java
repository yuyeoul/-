import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st= new StringTokenizer(bf.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		Map<String, String> map =new HashMap<String, String>();
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(bf.readLine());
			String str1=st.nextToken();
			String str2=st.nextToken();
			map.put(str1, str2);
		}
		for(int i=0;i<M;i++) {
			String str3=bf.readLine();
			bw.write(map.get(str3)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
