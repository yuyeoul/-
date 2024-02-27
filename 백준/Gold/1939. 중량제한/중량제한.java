import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[]arr;
    static class info{
        int dest,weight;

        public info(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    static boolean[] visited;
    static ArrayList<ArrayList<info>> list =new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        int first=0;
        int last=0;

        for(int i=0;i<M;i++){
            int f=sc.nextInt();
            int l= sc.nextInt();
            int w=sc.nextInt();

            list.get(f).add(new info(l,w));
            list.get(l).add(new info(f,w));
            last=Math.max(last,w);
        }
        int start=sc.nextInt();
        int end=sc.nextInt();
        while (first<=last){
            int mid=(first+last)/2;
            visited=new boolean[N+1];
            if(BFS(start,end,mid)){
                first=mid+1;
            }else{
                last=mid-1;
            }
        }
        System.out.println(last);

    }
    public static boolean BFS(int s,int e,int m){
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while (!q.isEmpty()){
            int n=q.poll();
            if(n==e){
                return true;
            }
            for(info i:list.get(n)){
                if(!visited[i.dest] && m<=i.weight){
                    visited[i.dest]=true;
                    q.add(i.dest);
                }
            }
        }
        return false;
    }
}
