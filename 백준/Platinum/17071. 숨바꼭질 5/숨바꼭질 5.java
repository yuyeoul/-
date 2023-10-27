import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int size = 500001;
	static int ans = Integer.MAX_VALUE;

	static class info {
		int l, c;

		public info(int l, int c) {
			super();
			this.l = l;
			this.c = c;
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if (N == K) {
			System.out.println(0);
		} else {
			bfs();
			System.out.println(ans);
		}
	}

	public static void bfs() {
		Queue<info> q = new LinkedList<>();
		boolean visit[][] = new boolean[size][2];
		q.add(new info(N, 0));
		visit[N][0] = true;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int counnt =0;
        //숨바꼭질 2와 유사
        //다른 점은 동생이 k초마다 k칸 움직인다
        //방문배열을 움직인 시간이 짝수인 지점과 홀수인 지점을 분리해서 만들고 각각 정보를 처리한다
		while (!q.isEmpty()) {
			info in = q.poll();
            //동생의 위치가 500000을 넘어선다면 -1
			if (K + ((2+in.c ) * (in.c + 1) / 2) > 500000) {
				ans = -1;
				return;
			}
            //움직인 시간이 짝수라면
			if ((in.c +1) % 2 == 0) {
                
				if (visit[K + ((2 + in.c) * (in.c + 1) / 2)][0] == true) {
					ans = in.c + 1;
					return;
				}
			} else {
				if (visit[K + ((2+in.c ) * (in.c + 1) / 2)][1] == true) {
					ans = in.c + 1;
					return;
				}
			}

			if (in.l + 1 < size) {
				if (in.l + 1 == K + ((2+in.c ) * (in.c + 1) / 2)) {
					if (in.c + 1 < min) {
						min = in.c + 1;
					} 
					break;
				} else {
					if ((in.c +1) % 2 == 0 && visit[in.l + 1][0] == false) {
						q.add(new info(in.l + 1, in.c + 1));
						visit[in.l + 1][0] = true;
					} else if ((in.c +1) % 2 != 0 && visit[in.l + 1][1] == false) {
						q.add(new info(in.l + 1, in.c + 1));
						visit[in.l + 1][1] = true;
					}
				}
			}

			if (in.l - 1 >= 0) {
				if (in.l - 1 == K + ((2+in.c ) * (in.c + 1) / 2)) {
					if (in.c + 1 < min) {
						min = in.c + 1;
						
					}
					break;
				} else {
					if ((in.c +1) % 2 == 0 && visit[in.l - 1][0] == false) {
						q.add(new info(in.l - 1, in.c + 1));
						visit[in.l - 1][0] = true;
					} else if ((in.c +1) % 2 != 0 && visit[in.l - 1][1] == false) {
						q.add(new info(in.l - 1, in.c + 1));
						visit[in.l - 1][1] = true;
					}
				}

			}

			if (in.l * 2 >= 0 && in.l * 2 < size) {
				if (in.l * 2 == K + ((2+in.c ) * (in.c + 1) / 2)) {
					if (in.c + 1 < min) {
						min = in.c + 1;
						
					} 
					break;
				} else {
					if ((in.c +1) % 2 == 0 && visit[in.l *2][0] == false) {
						q.add(new info(in.l *2, in.c + 1));
						visit[in.l + 1][0] = true;
					} else if ((in.c +1) % 2 != 0 && visit[in.l *2][1] == false) {
						q.add(new info(in.l *2, in.c + 1));
						visit[in.l *2][1] = true;
					}
				}
			}
		}
		ans = min;
		return;
	}
}