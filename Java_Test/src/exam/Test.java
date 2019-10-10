package exam;

import java.util.*;
import java.util.Map.Entry;
public class Test {
    public static void main(String[] args)   {
        Student s1 = new Student(1,"张三",18,"男");
        Student s2 = new Student(2,"李四",18,"男");
        Student s3 = new Student(3,"王五",18,"男");
        Student s4 = new Student(4,"赵六",18,"男");
//        Map<Integer,Student> map = new HashMap<Integer,Student>();

        int i = 5;
        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Test test = new Test();
        Map<Integer,Student> map = new HashMap<>();
        test.listToMap(list,map);
    }


    public void listToMap(List<Student> list ,Map<Integer,Student> map){
        Iterator<Student> it = list.iterator();

        while(it.hasNext()){
            Student st = it.next();
            System.out.println(st);
            map.put(st.getId(),st);


        }

        Set<Entry<Integer,Student>> set = map.entrySet();


        Iterator<Entry<Integer,Student>> it1 = set.iterator();

        while(it1.hasNext()){
            Entry<Integer,Student> entry = it1.next();
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }


    }
    public void mapToList(Map<Integer,Student > map){
        StudentEntry<Integer,Student > sEntry = new StudentEntry<>();
        List<StudentEntry<Integer,Student>> list = new ArrayList<>();
        Set<Entry<Integer,Student>> set = map.entrySet();
        for (Entry<Integer,Student> entry:set){

            sEntry.setKey( entry.getKey());
            sEntry.setValue(entry.getValue());
            list.add(sEntry);
        }
    }
}
