/**
 * Created by Shmidt on 20.07.2017.
 */
public class TEST {

    public Object x;
    public Object y;

    public TEST(Object x, Object y){
        this.x = x;
        this.y = y;
    }

    TEST[] array;
    int getLength(int[] array){
        return array.length;
    }

    public enum Colors {
        GREEN, RED, BLUE, YELLOW
    }
}

class Problem {
    static String s;
    static class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }
}
