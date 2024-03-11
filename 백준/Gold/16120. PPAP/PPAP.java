import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            //문자열 받아서 하나씩 뽑아
            char c =str.charAt(i);
            //P라면 넣고
            if(c=='P'){
                s.push(c);
            //A라면
            }else{
                //만약 이미 앞에 P가 두개이상 들어가 있고
                //A가 맨뒤에 오면 무조건 안되니까 맨뒤 아니고
                //A뒤에 P가 따라 온다면
                if(s.size()>=2 && i!=str.length()-1 && str.charAt(i+1)=='P'){
                    //앞에 P두개 꺼내기
                    s.pop();
                    s.pop();
                }else {
                    //위 조건이 아니라면 PPAP는 불가능해~
                    System.out.println("NP");
                    System.exit(0);
                }
            }
        }
        //ex)PPPAPAP
        //P->PP->PPP->위 조건 만족하니까 P두개 빠지면 P->PP->위조건 만족하니까 P두개 또 빠지고 ->P
        if (s.size()==1){
            //맨 마지막의 P는 스택에 남게 되므로 사이즈가 1이여야 PPAP
            System.out.println("PPAP");
        }else {
            System.out.println("NP");
        }



    }
}
