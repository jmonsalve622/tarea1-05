import java.util.ArrayList;
import java.util.Collections;

public class Deposito <T> {
    private ArrayList list;
    public Deposito() {
        list = new ArrayList();
    }
    public void add(T b) {
        list.add(b);
    }
    public T get() {
        if (list.size() > 0) {
            return (T) list.remove(0);
        }
        else {
            return null;
        }
    }
    public boolean empty() {
        if (list.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
