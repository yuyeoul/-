import java.util.Scanner;

public class Main {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        //숫자 개수
		N=sc.nextInt();
        //최대 구간 개수
		M=sc.nextInt();
		int arr[]=new int[N];
        //이분탐색 시작점
		int l=0;
        //이분탐색 끝점
		int r=0;
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
            //들어오는 숫자 중 가장 큰 값을 이분탐색 끝점으로 설정
            r=Math.max(r,arr[i]);
		}
		
		int ans=r;
		
		while(l<=r) {
            //중간 값
			int m=(l+r)/2;
            //search 메소드가 true면
			if(search(arr,m)) {
                //정답 갱신
                //최대값 중 최소값을 찾는 것이므로 Math.min
				ans=Math.min(ans, m);
                //이분탐색 끝점 갱신
				r=m-1;
			}else {
				l=m+1;
			}
		}
		System.out.println(ans);
		
		
	}
    //구간 나누기 조건 메소드
	public static boolean search(int arr[],int m) {
        //구간의 개수
		int cnt=1;
        //해당 구간의 최대,최소값
		int min=arr[0];
		int max=arr[0];
		for(int i=0;i<N;i++) {
            //최소값 갱신
			if(arr[i]<min) {
				min=arr[i];
			}
            //최대값 갱신
			if(arr[i]>max) {
				max=arr[i];
			}
			//최대와 최소의 차이가 이분탐색 기준값 보다 크다면
			if(max-min>m) {
                //구간 개수 ++
				cnt++;
                //새로운 구간 시작
				min=arr[i];
				max=arr[i];
			}
		}
        //구간 개수가 최대구간 개수보다 작거나 같다면 true
		if(cnt<=M) {
			return true;
		}else {
			return false;
		}
	}

}
