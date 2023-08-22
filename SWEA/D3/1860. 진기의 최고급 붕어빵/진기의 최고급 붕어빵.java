import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//N명의 사람 M초의 시간들이면 K개 붕어빵 생산 가능
		Scanner sc =new Scanner(System.in);
		//테케 개수
		int num= sc.nextInt();
		for(int tc=1;tc<=num;tc++) {
			//사람
			int N=sc.nextInt();
			//시간
			int M=sc.nextInt();
			//붕어빵생산량
			int K=sc.nextInt();
			//몇 초 뒤에 사람이 올지에 대한 배열
			int arr[]=new int [N];
			for(int i=0; i<N;i++) {
				arr[i]=sc.nextInt();
			}
			//오는 순서로 정렬시켜 놓기
			Arrays.sort(arr);
			//붕어빵 재고
			int boong=0;
			//11111초 이하까지 온다했으니 11112크기의 배열 생성
			int boongArr[]= new int[11112];
			//0초에는 붕어빵 0개
			boongArr[0]=boong;
			//1초부터 111111초까지
			for(int i=1;i<=11111;i++) {
				//M초가 더해질 때 마다 붕어빵 생산
				if(i%M==0) {
					//붕어빵 재고 더해서 배열에 더해주기
					boong+=K;
					boongArr[i]=boong;
				}else {
					boongArr[i]=boong;
				}
			}
			//진위판별 변수
			boolean tf= false;
			for(int i=0;i<arr.length;i++) {
				//붕어빵 재고 배열에 손님 도착시간을 인덱스로 넣었을 때 재고가 0이면 판매 불가능
				if(boongArr[arr[i]]==0) {
					System.out.println("#"+tc+" Impossible");
					tf= false;
					break;
				}else {
					//아니라면 붕어빵 재고 배열에서 1씩 빼주기
					for(int j=0;j<boongArr.length;j++) {
						if(boongArr[j]>0) {
							boongArr[j]-=1;
						}
					}
					tf=true;
				}
			}
			//출력
			if(tf==true) {
				System.out.println("#"+tc+" Possible");
			}
		}
	}

}
