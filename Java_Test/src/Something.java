public class Something {
    public static void main(String[] args){
        final Other o=new Other();
        new Something().addOne(o);//1
        new Thread(new Runnable() {

            @Override
            public void run() {

            }
        }).start();



    }
    public void addOne( Other o){
        o.i++;//2
        o =  new Other();//3
    }
}
class Other{
    public int i;

}
