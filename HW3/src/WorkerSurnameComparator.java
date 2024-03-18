import java.util.Comparator;

public class WorkerSurnameComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
