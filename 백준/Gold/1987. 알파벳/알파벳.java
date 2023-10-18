import java.util.Scanner;

public class Main {
    static int R, C;
    static int arr[][];
    static boolean visited[] = new boolean[26];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new int[R][C];
        //방문 배열 편하게 탐색하기 위해 int로 배열값 채우기
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j) - 65;
            }
        }
        //dfs호출
        dfs(0, 0, 0);
        System.out.println(ans);

    }

    public static void dfs(int r, int c, int cnt) {
        //만약 이미 방문한 알파벳이라면
        if (visited[arr[r][c]]) {
            //큰값 갱신하고
            ans = Math.max(cnt, ans);
            //리턴
            return;
        }
        //방문하지 않았다면 방문처리해주고
        visited[arr[r][c]] = true;
        //4방향탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            //배열의 범위 안쪽이라면
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                //새로운 rc값과 cnt를 하나 더해서 dfs호출
                dfs(nr, nc, cnt + 1);
            }
        }
        //여기는 이미 방문한 알파벳을 만나서 맨 마지막으로 호출된 dfs가 종료되고 도달한 곳
        //역으로 거슬러 올라가기 때문에 해당 알파벳 방문처리 취소
        visited[arr[r][c]] = false;


    }
}
