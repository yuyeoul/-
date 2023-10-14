import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //입력받을 배열칸,치킨집 개수
    static int N,M;
    //입력 받을 배열
    static int[][]arr;
    //정답출력 변수
    static int ans=Integer.MAX_VALUE;
    //조합을 위한 배열
    static boolean visited[];
    //치킨집과 집의 정보를 입력받을 클래스
    static class info{
        int r,c;

        public info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    //치킨집의 좌표를 저장할 리스트
    static List<info> clist;
    //집의 좌표를 저장할 리스트
    static List<info> hlist;
    //치킨집 선택 저장할 리스트
    static List<info> sel;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        arr=new int[N][N];
        clist=new ArrayList<>();
        hlist =new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==1){
                    hlist.add(new info(i,j));
                }else if(arr[i][j]==2){
                    clist.add(new info(i,j));
                }
            }
        }
        //치킨집 수만큼 방문배열 생성
        visited=new boolean[clist.size()];
        //치킨집 선택 리스트
        sel=new ArrayList<>();
        combi(0,0);
        System.out.println(ans);


    }
    //치킨집 조합 및 거리계산 메소드
    public static void combi(int d,int s){
        //depth가 치킨집 개수에 도달하면
        if(d==M){
            //거리합 저장 변수
            int sum=0;
            //집을 하나 뽑아서 치킨집 조합 리스트와 거리를 비교하여 최소값을 찾고 거리합에 더하기
            for(int i=0;i< hlist.size();i++){
                int dis=Integer.MAX_VALUE;
                //집 하나 뽑고
                info hi=hlist.get(i);
                for(int j=0;j<sel.size();j++){
                    //치킨집 조합에서 치킨집 하나 뽑고
                    info si=sel.get(j);
                    //거리계산해서
                    int a=Math.abs(si.r-hi.r)+Math.abs(si.c-hi.c);
                    //작은값 갱신
                    dis = Math.min(dis, a);
                    }
                //sum에 저장
                    sum+=dis;
                }
            //최종 출력값 보다 작으면 갱신
            ans = Math.min(ans, sum);
            return;
            }
        //치킨집 조합하는 부분
        for(int i=s;i<clist.size();i++){
            //치킨집 저장 리스트를 돌면서
            //해당 치킨집을 방문하지 않았다면
            if(!visited[i]){
                //방문처리하고
                visited[i]=true;
                //해당 치킨집 sel리스트에 추가
                sel.add(new info(clist.get(i).r,clist.get(i).c));
                //depth하나 늘리고 i하나 증가시켜서 재귀
                combi(d+1,i+1);
                //depth끝에 도달해서 return 으로 돌아온다면 해당 조합에 대한 계산은 끝났으니까
                //리스트의 맨마지막에 추가된거 지워주기
                sel.remove(sel.size()-1);
                //해당 부분 다시 미방문 처리
                visited[i] = false;

            }
        }
    }
}