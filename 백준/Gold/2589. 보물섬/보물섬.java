import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static char arr[][];
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static int ans=0;
	static class info{
		int r,c,v;

		public info(int r, int c, int v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new char[N][M];
		for(int i=0;i<N;i++) {
			String str=sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(int x,int y) {
		Queue<info> q= new LinkedList<>();
		boolean visited[][]=new boolean[N][M];
		q.add(new info(x,y,0));
		visited[x][y]=true;
		int max=0;
		while(!q.isEmpty()) {
			info in=q.poll();
			max=in.v;
			for(int i=0;i<4;i++) {
				int nr=in.r+dr[i];
				int nc=in.c+dc[i];
				if(nr>=0&&nr<N&&nc>=0&&nc<M) {
					if(arr[nr][nc]=='L'&&!visited[nr][nc]) {
						q.add(new info(nr, nc, in.v+1));
						visited[nr][nc]=true;
					}
				}
			}
		}
		if(max>ans) {
			ans=max;
		}
	}

}
