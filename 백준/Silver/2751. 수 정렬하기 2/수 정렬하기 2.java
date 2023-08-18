import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num= Integer.parseInt(bf.readLine());
		List<Integer> list =new ArrayList<>();
		for(int i=0;i<num;i++) {
			list.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(list);
		for(int i=0;i<num;i++) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		bw.close();

	}

}