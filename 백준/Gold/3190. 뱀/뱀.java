import java.util.*;

public class Main {
    static class info{
        int r;
        int c;

        public info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, K, L;
    static int[][] arr;
    static List<info> list;
    static Queue<info> q;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();

        arr=new int[N][N];
        list=new ArrayList<>();
        q=new LinkedList<>();

        for(int i=0;i<K;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            arr[x-1][y-1]=1;
        }
        L=sc.nextInt();
        for(int i=0;i<L;i++){
            int t=sc.nextInt();
            String d=sc.next();
            int dir=1;
            if(d.equals("L")){
                dir=-1;
            }
            list.add(new info(t,dir));
        }

        arr[0][0]=2;

        int ans=0;
        int time=0;
        int dir=0;
        info head=new info(0,0);
        q.add(head);

        while(true){
            ans++;

            int nx = head.r + dr[dir];
            int ny = head.c + dc[dir];

            if(nx < 0 || N <= nx || ny < 0 || N <= ny || arr[nx][ny] == 2){
                break;
            }

            if(arr[nx][ny] != 1){
                info tail = q.poll();
                arr[tail.r][tail.c] = 0;
            }

            head = new info(nx, ny);
            q.add(head);
            arr[nx][ny] = 2;

            if(time < L && list.get(time).r == ans){
                dir = (dir + list.get(time).c) % 4;
                if(dir==-1){
                    dir=3;
                }

                time++;
            }
        }

        System.out.println(ans);


    }
}
