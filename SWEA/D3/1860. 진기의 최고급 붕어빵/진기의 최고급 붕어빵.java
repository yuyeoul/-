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
			int N=sc.nextInt();
			int M=sc.nextInt();
			int K=sc.nextInt();
			
			int arr[]=new int [N];
			for(int i=0; i<N;i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			int boong=0;
			int boongArr[]= new int[11112];
			boongArr[0]=boong;
			for(int i=1;i<=11111;i++) {
				if(i%M==0) {
					boong+=K;
					boongArr[i]=boong;
				}else {
					boongArr[i]=boong;
				}
			}
			boolean tf= false;
			for(int i=0;i<arr.length;i++) {
				if(boongArr[arr[i]]==0) {
					System.out.println("#"+tc+" Impossible");
					tf= false;
					break;
				}else {
					for(int j=0;j<boongArr.length;j++) {
						if(boongArr[j]>0) {
							boongArr[j]-=1;
						}
					}
					tf=true;
				}
			}
			if(tf==true) {
				System.out.println("#"+tc+" Possible");
			}
		}
	}

}
