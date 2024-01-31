import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class info implements Comparable<info>{
        String name;
        int day,month,year;

        public info(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(info o) {
            if(year==o.year){
                if(month==o.month){
                    return o.day-day;
                }
                return o.month-month;
            }
            return o.year-year;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();

        List<info> list= new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new info(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(list);
        System.out.println(list.get(0).name);
        System.out.println(list.get(list.size()-1).name);

    }
}
