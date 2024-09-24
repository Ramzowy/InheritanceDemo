import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {

        Worker worker1 = new Worker("001", "David", "Daud", "Mr.", 2001, 25);

        Worker worker2 = new Worker("002", "Richard", "Henry", "Mr.", 2002, 30);

        Worker worker3 = new Worker("003", "Kevin", "Hart", "Mr.", 2003, 45);

        SalaryWorker s1 = new SalaryWorker("001", "Peter", "Jackson", "Mr.", 2001, 20, 41600);

        SalaryWorker s2 = new SalaryWorker("002", "Nick", "Culman", "Mr.", 2002, 25, 52000);

        SalaryWorker s3 = new SalaryWorker("003", "Ben", "Harris", "Mr.", 2003, 45, 93600);

        ArrayList<Worker> arrayList = new ArrayList<>();

        arrayList.add(worker1);

        arrayList.add(worker2);

        arrayList.add(worker3);

        arrayList.add(s1);

        arrayList.add(s2);

        arrayList.add(s3);

        double[] hoursWorked = {40, 50, 40};  // Three weekly pay periods

        System.out.println("\tTotalWeeklyPay\tWeeklyPay\tOvertimePay");
        System.out.println("\t=========================================");

             // Loop through the 3 weeks
        for (int week = 0; week < hoursWorked.length; week++) {
            double hours = hoursWorked[week];
            String weekLabel = "Week " + (week + 1);  // Display Week 1, Week 2, etc.

            System.out.println("\n\n\t" + weekLabel + " (" + hours + " hours worked):");

            // Loop through each worker and calculate/display pay
            for (Worker worker : arrayList) {

                System.out.println("\n\t" + worker.getFirstName() + " " + worker.getLastName() + ":");
                worker.displayWeeklyPay(hours);
            }
        }
            }
        }

