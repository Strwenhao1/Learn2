import javafx.scene.input.DataFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Vector;

public class Example  {
    String str = "good";
    char[] ch = {'a', 'b', 'c'};
    DataFormat dataFormat = new DataFormat("");
    public  static int no(int i){
        if(i==2){
            return 1;
        }

        if(i==1){
            return 0;
        }
        else {
            return no(i-1)+no(i-2);
        }
    }

    public static void main(String[] args) throws IOException {

        int sum=0;
        for(int i=1;i<10;i++){
            do{
                i++;
                if(i%2!=0)
                    sum+=i;
            }while(i<6);
        }
        System.out.println(sum);

    }
}
