import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{7,8,9};

        a=b;
        System.out.println(Arrays.toString(a));
    }
}
