import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E=sc.nextInt();
		int O=sc.nextInt();
		int[]arre=new int[E];
		int[]arro=new int[O];
		
		int cntE=1;
		int cntO=1;
		
		for(int i=0;i<E;i++) {
			arre[i]=sc.nextInt();
		}
		for(int i=0;i<O;i++) {
			arro[i]=sc.nextInt();
		}
		Arrays.sort(arre);
		Arrays.sort(arro);
        int NE=arre[0];
		int NO=arro[0];
		for(int i=0;i<E;i++) {
			if(arre[i]>=NE+100) {
				cntE++;
				NE=arre[i];
			}
		}
		for(int i=0;i<O;i++) {
			if(arro[i]>=NO+360) {
				cntO++;
				NO=arro[i];
			}
		}
		System.out.println(cntE+" "+cntO);
		
	}

}
