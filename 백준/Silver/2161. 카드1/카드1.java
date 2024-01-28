import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            q.add(i);
        }
        while (true){
            if(q.size()==1){
                break;
            }
            list.add(q.poll());
            int num=q.poll();
            q.add(num);
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print(q.poll());

    }
}
