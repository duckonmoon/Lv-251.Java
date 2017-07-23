/**
 * Created by Shmidt on 20.07.2017.
 */
public class Shows implements Runnable
{
    public static int i;

    public Shows(int i)
    {
        this.i = i;
    }
    public void run() {
        System.out.println(i);
    }
}