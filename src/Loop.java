import java.util.List;

public class Loop implements Runnable {
    public List<Thread> list;

    public Loop(List<Thread> list) {
        this.list = list;
    }

    @Override
    public void run() {
        long count10 = 0;
        long randNumCount = 0;
        while (!Thread.interrupted() && count10 < 10000) {
            long randomNum = (long) (Math.random() * 11);
            if (randomNum == 10) {
                count10++;
            }
            randNumCount++;
        }
        if (count10 == 10000) {
            synchronized (list) {
                for (Thread t : list) {
                    if (t.isAlive()) {
                        t.interrupt();
                    }
                }
            }
            System.out.println("Winner: " + Thread.currentThread().getName() + " ,random numbers: " + randNumCount);

        } else {
            System.out.println(Thread.currentThread().getName() + " : " + randNumCount + " , " + count10);
        }
    }
}
