import java.time.LocalDate;

public class Manager extends Worker{
    public Manager(String surname, String name, String middleName, String position, String phoneNumber, int salary, LocalDate birthDate) {
        super(surname, name, middleName, position, phoneNumber, salary, birthDate);
    }

    public Manager(String surname, String name, String middleName) {
        super(surname, name, middleName);
    }

    public static void addSalary(Worker[] workers, int addAmount) {
        for (Worker worker : workers) {
            if (worker.getClass().equals(Worker.class)) {
                worker.setSalary(worker.getSalary() + addAmount);
            }
        }
        System.out.println("Зарплата повышена всем, кроме руководителей успешно!!!");
    }

    public void assign (Task task, Worker worker){
        worker.assign(task);
    }
}
