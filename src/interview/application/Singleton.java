package interview.application;

/**
 * @author kanglo
 * @create 2020-10-2020/10/13 22:51
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){

    }
    public Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
