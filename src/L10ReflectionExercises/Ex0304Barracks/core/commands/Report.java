package L10ReflectionExercises.Ex0304Barracks.core.commands;


public class Report extends Command {


    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute()  {
        return this.getRepository().getStatistics();
    }
}
