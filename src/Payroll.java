import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Payroll implements Runnable {

    static ArrayList<String> paymentsList = new ArrayList<>();

    static AtomicInteger salaryIvanov = new AtomicInteger(2000);
    static AtomicInteger salaryPetrov = new AtomicInteger(2500);
    static AtomicInteger salarySuvorov = new AtomicInteger(3000);

    static int bonus = 700;

    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        Thread t1 = new Thread(payroll);
        Thread t2 = new Thread(payroll);
        payroll.doWork();
        t1.start();
        t2.start();
        System.out.println(paymentsList.get(0) + " " + salaryIvanov);
        System.out.println(paymentsList.get(1) + " " + salaryPetrov);
        System.out.println(paymentsList.get(2) + " " + salarySuvorov);
    }

    @Override
    public void run() {
            paymentsList.add(0, "Ivanov");
            paymentsList.add(1, "Petrov");
            paymentsList.add(2, "Suvorov");
        }

    public synchronized void doWork() {
        salaryIvanov.addAndGet(bonus);
        salaryPetrov.addAndGet(bonus);
        salarySuvorov.addAndGet(bonus);
    }
}


