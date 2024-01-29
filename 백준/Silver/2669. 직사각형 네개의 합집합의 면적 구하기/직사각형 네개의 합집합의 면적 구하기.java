import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int [][]map=new int[101][101];


        for(int tc=1;tc<=4;tc++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            for(int i=y1;i<y2;i++){
                for(int j=x1;j<x2;j++){
                    map[i][j]=1;
                }
            }
        }
        int sum=0;
        
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                if(map[i][j]==1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
