package interview.application;

/**
 * @author kanglo
 * @create 2020-10-2020/10/13 22:34
 */
public class ThreadPrinter implements Runnable {
    private String name;
    private Object prev;
    private Object self;
    public ThreadPrinter(String name,Object self,Object prev){
        this.name = name;
        this.self = self;
        this.prev = prev;
    }
    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (prev){
                synchronized (self){
                    System.out.println(name);
                    count--;
                    self.notifyAll();

                }
                try {
                    if (count == 0)
                        prev.notifyAll();
                    else
                        prev.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter printerA = new ThreadPrinter("A",a,c);
        ThreadPrinter printerB = new ThreadPrinter("B",b,a);
        ThreadPrinter printerC = new ThreadPrinter("C",c,b);
        new Thread(printerA).start();
        Thread.sleep(10);
        new Thread(printerB).start();
        Thread.sleep(10);
        new Thread(printerC).start();
        Thread.sleep(10);

    }
}
