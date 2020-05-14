package club.banyuan;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


    private Weekday() {
    }


    private int getCode() {
        return ordinal() + 1;
    }

    public static boolean isWeekday(Weekday day) {

        return day.getCode() <= FRIDAY.getCode();
    }

    public static boolean isHoliday(Weekday day) {
        return !isWeekday(day);
    }

    public static Weekday getday(String day) {
        return Weekday.valueOf(day);
//        switch(day.toString){
//            case "Monday":
//                return MONDAY;
//            case "Tuesday":
//                return TUESDAY;
//            case "Wednesday":
//                return WEDNESDAY;
//            case "Thursday":
//                return THURSDAY;
//            case "Friday":
//                return FRIDAY;
//            case "Saturday":
//                return SATURDAY;
//                case
//        }
    }

    @Override
    public String toString() {
        return this.name();
    }


}
