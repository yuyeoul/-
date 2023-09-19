import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	
	static class info{
		int x,y;
		String c;
		info(int x, int y,String c){
			this.x=x;
			this.y=y;
			this.c=c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String arr[][]=new String[num][num];
		String carr[][]=new String[num][num];
		
		boolean visited[][]=new boolean[num][num];
		boolean cvisited[][]=new boolean[num][num];
		for(int i=0;i<num;i++) {
			String ar[]=sc.next().split("");
			for(int j=0;j<num;j++) {
				String str=ar[j];
				arr[i][j]=str;
				if(str.equals("R")) {
					carr[i][j]="G";
				}else{
					carr[i][j]=str;
				}
			}
		}
		int dc[]= {-1,1,0,0};
		int dr[]= {0,0,1,-1};
		int ans=0;
		int ans1=0;
		while(true) {
			Queue<info> queue=new LinkedList<>();
			boolean tf = false;
			for(int i=0;i<num;i++) {
				for(int j=0;j<num;j++) {
					if(!visited[i][j]) {
						queue.add(new info(i, j, arr[i][j]));
						visited[i][j]=true;
						tf=true;
						break;
					}
				}
				if(tf==true) {
					break;
				}
			}
			if(tf==false) {
				break;
			}
			while(!queue.isEmpty()) {
				info rgb=queue.poll();
				for(int i=0;i<4;i++) {
					int nx=rgb.x+dc[i];
					int ny=rgb.y+dr[i];
					if(nx>=0&&nx<num&&ny>=0&&ny<num&&!visited[nx][ny]) {
						if(arr[nx][ny].equals(rgb.c)) {
							visited[nx][ny]=true;
							queue.add(new info(nx,ny,rgb.c));
						}
					}
				}
			}
			ans++;
		}
		while(true) {
			Queue<info> queue1=new LinkedList<>();
			boolean tf = false;
			for(int i=0;i<num;i++) {
				for(int j=0;j<num;j++) {
					if(!cvisited[i][j]) {
						queue1.add(new info(i, j, carr[i][j]));
						cvisited[i][j]=true;
						tf=true;
						break;
					}
				}
				if(tf==true) {
					break;
				}
			}
			if(tf==false) {
				break;
			}
			while(!queue1.isEmpty()) {
				info rgb=queue1.poll();
				for(int i=0;i<4;i++) {
					int nx=rgb.x+dc[i];
					int ny=rgb.y+dr[i];
					if(nx>=0&&nx<num&&ny>=0&&ny<num&&!cvisited[nx][ny]) {
						if(carr[nx][ny].equals(rgb.c)) {
							cvisited[nx][ny]=true;
							queue1.add(new info(nx,ny,rgb.c));
						}
					}
				}
			}
			ans1++;
		}
		System.out.println(ans+" "+ans1);
		
	}

}
