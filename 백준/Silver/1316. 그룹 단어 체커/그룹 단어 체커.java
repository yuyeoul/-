import java.util.Scanner;

public class Main {
    static boolean[] eng;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int cnt=0;
        sta:for(int i=0;i<N;i++){
            String str= sc.next();
            eng=new boolean[26];
            for(int j=0;j<str.length();j++){
                int num=str.charAt(j)-97;
                if(j==0){
                    eng[num]=true;
                }else{
                    if(str.charAt(j)==str.charAt(j-1)){
                        continue;
                    }else{
                        if(!eng[num]){
                            eng[num]=true;
                        }else{
                            continue sta;
                        }
                    }
                }

            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
