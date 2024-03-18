import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
                new Manager("Vezunchikov", "Oleg", "Petrovich","SEO",
                        "+7-777-777-77-77", 10000,
                        LocalDate.of(1950, 7, 21)),
                new Worker("Ivanov", "Ivan", "Ivanovich","backend-developer",
                        "+7-999-888-77-66", 100,
                        LocalDate.of(1940, 10, 17)),
                new Worker("Petrov", "Ivan", "Pavlovich", "Janitor",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1969, 11, 17)),
                new Worker("Pavlov", "Ivan", "Pavlovich", "Janitor",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1980, 11, 17)),
                new Worker("Denisov", "Ivan", "Pavlovich", "Janitor",
                        "+7-999-111-22-66", 200,
                        LocalDate.of(1962, 11, 17)),
                new Worker("Nosov", "Oleg", "Pavlovich", "Janitor",
                        "+7-999-111-22-66", 2000,
                        LocalDate.of(1970, 11, 17))
        };

        System.out.println("Average age: " + getAverageAge(workers));
        System.out.println("Average salary: " + getAverageSalary(workers));

        Worker.addSalary(workers, 45, 50);

        System.out.println(Arrays.toString(workers));

        List<Worker> workerList = Arrays.asList(workers);

        System.out.println("---".repeat(5));
        Collections.sort(workerList);
        System.out.println(workerList);
        System.out.println("---".repeat(5));

        workerList.sort(new WorkerSalaryComparator());
        System.out.println(workerList);

        System.out.println("---".repeat(5));

        workerList.sort((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(workerList);

        System.out.println("---".repeat(5));

        workerList.sort(new WorkerSurnameComparator());
        System.out.println(workerList);

        Manager.addSalary(workers, 100);
        System.out.println(workerList);

        /**Задача, которую назначат себе все сотрудники, кроме менеджера*/
        Task task1 = new Task("Clean", "Clean room, wash car, wash the dishes");
        /**Задача, которую назначит себе менеджер*/
        Task task2 = new Task("Count money", "Do nothing, count the money, have fun");
        /**Задача, которую менеджер назначит всем остальным сотрудникам*/
        Task task3 = new Task("Overtime work", "It will be better if you will work at your weekend");

        for (Worker worker : workerList) {
            if (worker.getClass().equals(Worker.class)) {
                worker.assign(task1);
            }
            if (worker.getClass().equals(Manager.class)) {
                worker.assign(task2);
                Manager manager = (Manager) worker;
                for (Worker worker1 : workerList) {
                    if (worker1.getClass().equals(Worker.class)) {
                        manager.assign(task3, worker1);
                    }
                }
            }
        }
        System.out.println(workerList);

    }

    public static double getAverageAge(Worker[] array) {
        int sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / (double) array.length;
    }

    public static double getAverageSalary(Worker[] array) {
        int sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / (double) array.length;
    }
}