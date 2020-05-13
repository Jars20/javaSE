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


    public int getCode() {
        return ordinal() + 1;
    }

    public static boolean isWeekday(Weekday day) {
        return day.getCode() <= 5;
    }

    public static boolean isHoliday(Weekday day) {
        return !isWeekday(day);
    }

    public static Weekday getday(String days) {
        for (Weekday weekday : Weekday.values()) {
            if (weekday.toString().equals(days)) {
                return weekday;
            }
        }
        return null;
//        switch(days.toString){
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
