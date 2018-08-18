package L07EnumsAndAnotations.Ex01Weekday;

public class WeeklyEntry implements Comparable<WeeklyEntry> {
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday, this.notes);
    }

    @Override
    public int compareTo(WeeklyEntry other) {
        return compareDayAscending(this.weekday, other.weekday);
    }

    public static int compareDayAscending(Weekday entryOne, Weekday entryTwo) {
        return Integer.compare(entryOne.ordinal(), entryTwo.ordinal());
    }

    public static int compareDayDescending(Weekday entryOne, Weekday entryTwo) {
        return Integer.compare(entryTwo.ordinal(), entryOne.ordinal());
    }
}
