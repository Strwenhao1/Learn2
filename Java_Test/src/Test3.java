import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        Set<Student> set = new TreeSet<Student>();

        while (flag) {
            String info = scanner.nextLine();
            if (info.equals("exit")) {
                break;
            }
            String[] s = info.split("#");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            int age = Integer.parseInt(s[2]);
            Student student = new Student(id, name, age);
            set.add(student);
        }
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            fw = new FileWriter("d:/ee.txt");
            bfw = new BufferedWriter(fw);
            for (Student s : set) {
                System.out.println(s);
                try {
                   bfw.write(s.toString());
                   bfw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfw != null) {
                    bfw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
