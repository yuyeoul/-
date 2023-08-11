import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(bf.readLine());
		int arr[]=new int [num];
		for(int i=0;i<num;i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);
		for(int i=0;i<num;i++) {
			bw.write(Integer.toString(arr[i])+"\n");
		}
		bw.close();
	}

}