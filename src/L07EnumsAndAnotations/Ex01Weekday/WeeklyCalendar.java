package L07EnumsAndAnotations.Ex01Weekday;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WeeklyCalendar {
    private List<WeeklyEntry> weeklyEntries;

    public WeeklyCalendar() {
        this.weeklyEntries = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        this.weeklyEntries.add(new WeeklyEntry(weekday, notes));
    }


    public Iterable<WeeklyEntry> getWeeklySchedule() {
        return this.weeklyEntries
                .stream()
//                .sorted(Comparator.comparing(WeeklyEntry::getWeekday))
                .sorted((a,b) -> WeeklyEntry.compareDayAscending(a.getWeekday(),b.getWeekday()))
//                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
