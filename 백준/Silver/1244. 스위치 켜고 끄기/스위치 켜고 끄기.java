import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		int pe = sc.nextInt();
		for (int i = 0; i < pe; i++) {
			if (sc.nextInt() == 1) {
				int m = sc.nextInt();
				int m1 = m;
				int iq = 2;
				while (true) {
					if (arr[m1 - 1] == 0) {
						arr[m1 - 1] = 1;
					} else {
						arr[m1 - 1] = 0;
					}
					m1 = iq * m;
					iq++;
					if (m1 > arr.length) {
						break;
					}
				}
			} else {
				int f = sc.nextInt() - 1;
				int d = 0;
				while (true) {
					if (((f - d) >= 0 && (f + d) <= arr.length - 1) && arr[f - d] == arr[f + d]) {
						d++;
					} else {
						d--;
						break;
					}
				}
				for (int j = f - d; j <= f + d;j++) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
            if(i<arr.length-1) {
			System.out.print(arr[i]+" ");
        }else {
				System.out.print(arr[i]);
			}
            if((i+1)%20==0) {
				System.out.println();
			}
		}

	}

}