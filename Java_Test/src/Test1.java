//import list.List;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List list = new ArrayList();


        Vector vector = new Vector();
        vector.add(123);
        Vector vc = new Vector<>();
        vc.add(789);
        vc.add(999);
        vector.addAll(vc);
        vector.addElement("element");
        vector.contains(789);



    }
}
