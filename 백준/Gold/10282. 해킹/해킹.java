import java.util.*;

public class Main {
    static int n,d,c,cnt;
    static int[]cost;
    static List<List<info>> list;
    static int INF=Integer.MAX_VALUE;
    static class  info implements Comparable<info>{
        int a,s;

        public info(int a, int s) {
            this.a = a;
            this.s = s;
        }

        @Override
        public int compareTo(info o) {
            return s-o.s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int tc=1;tc<=T;tc++){
            n=sc.nextInt();
            d=sc.nextInt();
            c=sc.nextInt();
            cnt=1;
            //직빵 감염보다 돌아서 감염되는게 빠를수도 있다.
            list= new ArrayList<>();
            for(int i=0;i<=n;i++){
                list.add(new ArrayList<>());
            }
            cost=new int[n+1];
        
            Arrays.fill(cost,INF);
            for(int i=0;i<d;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int s=sc.nextInt();
                list.get(b).add(new info(a,s));
            }
            cost[c]=0;
            dijkstra();
            int max=0;
            for(int i=1;i<=n;i++){
                if(cost[i]!=INF){
                    max=Math.max(max,cost[i]);
                }
            }
            System.out.println(cnt+" "+max);
        }
    }
    public static void dijkstra(){
        PriorityQueue<info> pq=new PriorityQueue<>();
        pq.add(new info(c,0));
        while (!pq.isEmpty()){
            info in = pq.poll();
            if(in.s>cost[in.a]){
                continue;
            }
            for(info i:list.get(in.a)){
                if(cost[i.a]>cost[in.a]+i.s){
                    if(cost[i.a]==INF){
                        cnt++;
                    }
                    cost[i.a]=cost[in.a]+i.s;
                    pq.add(new info(i.a,cost[i.a]));
                }
            }


        }
    }

}
