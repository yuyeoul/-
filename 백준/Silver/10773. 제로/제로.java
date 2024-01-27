import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int tc=0;tc<N;tc++){
            int num=sc.nextInt();
            if(num==0){
                stack.pop();
            }else{
                stack.add(num);
            }
        }
        int sum=0;
        while (!stack.isEmpty()){
            sum+=stack.pop();
            //stack.pop();
        }
        System.out.println(sum);



    }
}
