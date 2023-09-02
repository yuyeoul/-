import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int up=sc.nextInt();
		int down= sc.nextInt();
		int h=sc.nextInt();
		
		int day = (h - down) / (up - down);
        
		if ((h - down) % (up - down) != 0) {
			day++;
		}
		System.out.println(day);
	}

}
