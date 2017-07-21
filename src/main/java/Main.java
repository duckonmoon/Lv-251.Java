/**
 * Created by Shmidt on 20.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new Shows(4)).start();
        try {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        new Thread(new Shows(3)).start();
        try {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        new Thread(new Shows(1)).start();
    }
}
