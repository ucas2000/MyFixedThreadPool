import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class TEST {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5); // 队列的容量为5
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("数据 " + i + "被加入到队列当中");
                } catch (InterruptedException e) {
                    System.out.println("出现了中断异常");
                    // 如果出现中断异常 则退出 线程就不会一直在 put 方法被挂起了
                    return;
                }finally {
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
    }

}
