import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class info {
		int x,y,day;
		info(int x, int y,int day) {
			this.x = x;
			this.y = y;
			this.day=day;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int arr[][] = new int[col][row];
		boolean visited[][]=new boolean[col][row];
		int ans=0;
		Queue<info> queue = new LinkedList<>();
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					queue.add(new info(i,j,0));
					visited[i][j]=true;
				}
			}
		}
		int dc[]= {-1,1,0,0};
		int dr[]= {0,0,1,-1};
		
		while(!queue.isEmpty()) {
			info to= queue.poll();
			ans=to.day;
			for(int i=0;i<4;i++) {
				int nx=to.x+dc[i];
				int ny=to.y+dr[i];
				if(nx>=0&&nx<col&&ny>=0&&ny<row&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					if(arr[nx][ny]==0) {
						arr[nx][ny]=1;
						queue.add(new info(nx,ny,to.day+1));
					}
				}
			}
		}
		boolean flag=true;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (arr[i][j] == 0) {
					flag=false;
				}
			}
		}
		if(flag==true) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
		
	}

}
