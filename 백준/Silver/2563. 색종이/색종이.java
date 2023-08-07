import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][]=new int[101][101];
		int num = sc.nextInt();
		int[] xarr=new int[num];
		int[] yarr=new int[num];
		for(int i=0;i<num;i++) {
			xarr[i]=sc.nextInt();
			yarr[i]=sc.nextInt();
			for(int j=yarr[i];j<yarr[i]+10;j++) {
				for(int k=xarr[i];k<xarr[i]+10;k++) {
					map[j][k]=(i+1);
				}
			}
		}
		int cnt=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++){
				if(map[i][j]!=0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
