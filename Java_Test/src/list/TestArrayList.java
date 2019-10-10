package list;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("11111");
        list.add("22222");
        list.add("33333");
        list.add("44444");
        list.add("55555");
        System.out.println(list);
        list.add(3,"AAAAA");
        System.out.println(list);

        System.out.println(list.get(3));

        list.remove(3);
        System.out.println(list.get(3));
        System.out.println("================");
        Iterator it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
