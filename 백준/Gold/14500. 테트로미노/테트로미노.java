import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int arr[][]=new int [N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int max =0;
		int dr[]= {-1,1,0,0};
		int dc[]= {0,0,-1,1};
		
		boolean vi[][]=new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int sum1=arr[i][j];
				vi[i][j]=true;
				for(int a=0;a<4;a++) {
					int nr=i+dr[a];
					int nc=j+dc[a];
					if(nr>=0&&nc>=0&&nr<N&&nc<M&&!vi[nr][nc]) {
						int sum2=sum1;
						sum2+=arr[nr][nc];
						vi[nr][nc]=true;
						
						for(int b=0;b<3;b++) {
							for(int c=b+1;c<4;c++) {
								int nnr1=nr+dr[b];
								int nnc1=nc+dc[b];
								int nnr2=nr+dr[c];
								int nnc2=nc+dc[c];
								if(nnr1>=0&&nnc1>=0&&nnr1<N&&nnc1<M&&!vi[nnr1][nnc1]&&nnr2>=0&&nnc2>=0&&nnr2<N&&nnc2<M&&!vi[nnr2][nnc2]) {
									int sum3=sum2;
									sum3+=arr[nnr1][nnc1];
									sum3+=arr[nnr2][nnc2];
									if(sum3>max) {
										max=sum3;
										
//										System.out.println("i:"+i+" j:"+j+" value:"+arr[i][j]);
//										System.out.println("nr:"+nr+" nc:"+nc+" value:"+arr[nr][nc]);
//										System.out.println("nnr1:"+nnr1+" nnc1:"+nnc1+" value:"+arr[nnr1][nnc1]);
//										System.out.println("nnr2:"+nnr2+" nnc2:"+nnc2+" value:"+arr[nnr2][nnc2]);
									}
								}
							}
						}
						
						for(int b=0;b<4;b++) {
							int nnr=nr+dr[b];
							int nnc=nc+dc[b];
							if(nnr>=0&&nnc>=0&&nnr<N&&nnc<M&&!vi[nnr][nnc]) {
								int sum3=sum2;
								sum3+=arr[nnr][nnc];
								vi[nnr][nnc]=true;
								for(int c=0;c<4;c++) {
									int nnnr=nnr+dr[c];
									int nnnc=nnc+dc[c];
									if(nnnr>=0&&nnnc>=0&&nnnr<N&&nnnc<M&&!vi[nnnr][nnnc]) {
										int sum4=sum3;
										sum4+=arr[nnnr][nnnc];
										if(sum4>max) {
											max=sum4;
										}
									}
								}
								vi[nnr][nnc]=false;
							}
						}
						vi[nr][nc]=false;
					}
				}
				vi[i][j]=false;
				
			}
		}
		System.out.println(max);
		
	}

}
