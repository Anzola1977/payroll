import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Payroll implements Runnable {

    static ArrayList payments = new ArrayList<>();

    static AtomicInteger salary = new AtomicInteger(2000);

    static int bonus = 700;

    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        Thread t1 = new Thread(payroll);
        Thread t2 = new Thread(payroll);
        payroll.doWork();
        t1.start();
        t2.start();
        System.out.println(payments);
    }

    @Override
    public void run() {
            payments.add(0, "Ivanov");
            payments.add(0, salary);
            payments.add(1, salary);
            payments.add(2, salary);
        }

    public void doWork() {
        salary.addAndGet(bonus);
    }
}


