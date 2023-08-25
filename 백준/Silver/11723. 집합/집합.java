import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			String fx = input[0];

			if (input.length > 1) {
				int num = Integer.parseInt(input[1]);

				if (fx.equals("add")) {
					set.add(num);
				} else if (fx.equals("remove")) {
					if (set.contains(num)) {
						set.remove(num);
					}
				} else if (fx.equals("check")) {
					if (set.contains(num)) {
						bw.write(1 + "\n");
					} else {
						bw.write(0 + "\n");
					}
				} else if (fx.equals("toggle")) {
					if (set.contains(num)) {
						set.remove(num);
					} else {
						set.add(num);
					}
				}
			} else {
				if (fx.equals("all")) {
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
				} else {
					set.clear();
				}
			}

		}
		bw.flush();
		bw.close();

	}
}
