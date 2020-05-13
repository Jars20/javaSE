package club.banyuan;

import club.banyuan.Weekday;

public class Main {
    public static  void isHoliday(Weekday day) {
        if(Weekday.isHoliday(day)){
            System.out.println(day.toString()+" Is Holiday");
        }
        else{
            System.out.println(day.toString()+" Is Not Holiday");
        }

    }

    public static void main(String[] args) {
        Weekday Sat =Weekday.getday("SATURDAY");
        System.out.println(Sat.name());
        for (Weekday value : Weekday.values()) {
            isHoliday(value);
            System.out.println("该日距离星期六"+value.compareTo(Sat)+"天");
        }



    }
}
