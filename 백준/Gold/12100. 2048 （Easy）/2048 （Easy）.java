import java.util.Scanner;

public class Main {
    static int N;
    static int [][]arr;
    static int []dr={-1,1,0,0};
    static int []dc={0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        arr=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int ans=0;
     
        for(int a=0;a<4;a++){
            int[][] dupli1=new int[N][N];
            for(int f=0;f<N;f++){
                for(int g=0;g<N;g++){
                    dupli1[f][g]=arr[f][g];
                }
            }
            move(dupli1,a);
            for(int b=0;b<4;b++){
                int[][] dupli2=new int[N][N];
                for(int f=0;f<N;f++){
                    for(int g=0;g<N;g++){
                        dupli2[f][g]=dupli1[f][g];
                    }
                }
                move(dupli2,b);
                for(int c=0;c<4;c++){
                    int[][] dupli3=new int[N][N];
                    for(int f=0;f<N;f++){
                        for(int g=0;g<N;g++){
                            dupli3[f][g]=dupli2[f][g];
                        }
                    }
                    move(dupli3,c);
                    for(int d=0;d<4;d++){
                        int[][] dupli4=new int[N][N];
                        for(int f=0;f<N;f++){
                            for(int g=0;g<N;g++){
                                dupli4[f][g]=dupli3[f][g];
                            }
                        }
                        move(dupli4,d);
                        for(int e=0;e<4;e++){
                            int[][] dupli5=new int[N][N];
                            for(int f=0;f<N;f++){
                                for(int g=0;g<N;g++){
                                    dupli5[f][g]=dupli4[f][g];
                                }
                            }
                            move(dupli5,e);
                            for(int i=0;i<N;i++){
                                for(int j=0;j<N;j++){
                                    ans=Math.max(dupli5[i][j],ans);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }
    public static int[][] move(int [][]arr1,int dir){
        boolean[][] visited = new boolean[N][N];
        //0:상 1:하 2:좌 3:우
        if(dir==0){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr1[i][j]!=0){
                        int nr=i;
                        int nc=j;
                        while (true){
                            nr+=dr[dir];
                            nc+=dc[dir];
                            if(nr<0){
                                break;
                            }
                            if(arr1[nr][nc]!=0 || nr==0) {
                                int num=arr1[i][j];
                                arr1[i][j]=0;
                                if ((arr1[nr][nc] == num && !visited[nr][nc])) {
                                    arr1[nr][nc]+=num;
                                    visited[nr][nc]=true;
                                } else if (arr1[nr][nc]==0) {
                                    arr1[nr][nc]+=num;
                                } else {
                                    arr1[nr+1][nc] = num;
                                }
                                break;
                            }
                        }
                    }

                }
            }
        } else if (dir==1) {
            for(int i=N-1;i>=0;i--){
                for(int j=N-1;j>=0;j--){
                    if(arr1[i][j]!=0){
                        int nr=i;
                        int nc=j;
                        while (true){
                            nr+=dr[dir];
                            nc+=dc[dir];
                            if(nr>=N){
                                break;
                            }
                            if(arr1[nr][nc]!=0||nr==N-1) {
                                int num=arr1[i][j];
                                arr1[i][j]=0;
                                if ((arr1[nr][nc] == num && !visited[nr][nc])) {
                                    arr1[nr][nc]+=num;
                                    visited[nr][nc]=true;
                                }else if (arr1[nr][nc]==0) {
                                    arr1[nr][nc]+=num;
                                }
                                else {
                                    arr1[nr-1][nc] = num;
                                }
                                break;
                            }
                        }
                    }

                }
            }
        } else if (dir==2) {
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr1[i][j]!=0){
                        int nr=i;
                        int nc=j;
                        while (true){
                            nr+=dr[dir];
                            nc+=dc[dir];
                            if(nc<0){
                                break;
                            }
                            if(arr1[nr][nc]!=0 || nc==0) {
                                int num=arr1[i][j];
                                arr1[i][j]=0;
                                if (arr1[nr][nc] == num && !visited[nr][nc]) {
                                    arr1[nr][nc]+=num;
                                    visited[nr][nc]=true;
                                } else if (arr1[nr][nc]==0) {
                                    arr1[nr][nc]+=num;
                                } else {
                                    arr1[nr][nc+1] = num;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            for(int i=N-1;i>=0;i--){
                for(int j=N-1;j>=0;j--){
                    if(arr1[i][j]!=0){
                        int nr=i;
                        int nc=j;
                        while (true){
                            nr+=dr[dir];
                            nc+=dc[dir];
                            if(nc>=N){
                                break;
                            }
                            if(arr1[nr][nc]!=0||nc==N-1) {
                                int num=arr1[i][j];
                                arr1[i][j]=0;
                                if ((arr1[nr][nc] == num && !visited[nr][nc])) {
                                    arr1[nr][nc]+=num;
                                    visited[nr][nc]=true;
                                }else if (arr1[nr][nc]==0) {
                                    arr1[nr][nc]+=num;
                                }  else {
                                    arr1[nr][nc-1] = num;
                                }
                                break;
                            }
                        }
                    }

                }
            }
        }

        return arr1;
    }
}
