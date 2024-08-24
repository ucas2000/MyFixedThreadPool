import com.thread.MyFixedThreadPool;

//class MyTask implements Runnable {
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName());
//    }
//}


public class test2 {
    public static void main(String[] args) {
        MyFixedThreadPool pool = new MyFixedThreadPool(5, 10); // 开启5个线程 任务队列当中最多只能存1024个任务
        for (int i = 0; i < 12; i++) {
//            pool.submit(new MyTask());
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName()); // 提交的任务就是打印线程自己的名字
            });
        }
        pool.shutDown();
    }
}
