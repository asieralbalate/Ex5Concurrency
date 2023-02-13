import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new Vector<>();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Loop(list));
            list.add(t);
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }
    }
}
