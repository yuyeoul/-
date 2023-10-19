import java.util.*;

public class Main {
    static int N, M;
    static int arr[][];
    static boolean visited[][];
    static boolean svisit[];
    static int dupli[][];
    static List<info> sel = new ArrayList<>();
    static List<info> list = new ArrayList<>();
    static Queue<info> q = new LinkedList<>();
    static List<info> qlist = new LinkedList<>();
    static int ans = 0;
    static int sum = 0;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static class info {
        int r, c;

        public info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) {
                    list.add(new info(i, j));
                } else if (arr[i][j] == 2) {
                    q.add(new info(i, j));
                    qlist.add(new info(i, j));
                    visited[i][j] = true;
                }
            }
        }
        svisit = new boolean[list.size()];
        combi(0, 0);
        System.out.println(ans);
    }

    public static void bfs() {
        if (q.isEmpty()) {
            visited = new boolean[N][M];
            for(int i=0;i<qlist.size();i++){
                q.add(qlist.get(i));
                visited[qlist.get(i).r][qlist.get(i).c] = true;
            }
        }
        while (!q.isEmpty()) {
            info in = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = in.r + dr[i];
                int nc = in.c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (!visited[nr][nc] && dupli[nr][nc] == 0) {
                        q.add(new info(nr, nc));
                        visited[nr][nc] = true;
                        dupli[nr][nc] = 2;
                    }
                }
            }
        }
    }

    public static void combi(int d, int s) {
        if (d == 3) {
            
            dupli=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    dupli[i][j]=arr[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                dupli[sel.get(i).r][sel.get(i).c] = 1;
            }
            bfs();
            sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dupli[i][j] == 0) {
                        sum++;
                    }
                }
            }

            ans = Math.max(ans, sum);
            return;
        }

        for (int i = s; i < list.size(); i++) {
            if (!svisit[i]) {
                svisit[i] = true;
                sel.add(new info(list.get(i).r, list.get(i).c));
                combi(d + 1, i + 1);
                sel.remove(sel.size() - 1);
                svisit[i] = false;
            }
        }
    }
}
