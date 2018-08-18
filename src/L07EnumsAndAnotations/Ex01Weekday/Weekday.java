package L07EnumsAndAnotations.Ex01Weekday;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        StringBuilder weekDay = new StringBuilder(this.name().toLowerCase());
        weekDay.setCharAt(0, this.name().charAt(0));
        return weekDay.toString();
    }
}
