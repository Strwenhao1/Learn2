package com.bjsxt.goods;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class store {
    public static Map<Integer, goods> map;
    public static addGoods add = new addGoods();

    public static void main(String[] args) {
        goods good1 = new goods(1, 198, "礼盒月饼", 88);
        goods good2 = new goods(2, 1076, "中秋套装", 33);
        goods good3 = new goods(3, 98, "普通月饼", 73);
        goods good4 = new goods(4, 333, "端午套装", 38);
        goods good5 = new goods(5, 35, "咸鸭蛋+粽子", 81);
        map = new TreeMap<Integer, goods>();
        add.addNewGoods(good1, good2, good3, good4, good5);
        Scanner scanner = new Scanner(System.in);
        Search s = new Search();
        Boolean bo = true;
        Boolean flag = true;
        while (bo) {
            System.out.println("[1] 商品展示");
            System.out.println("[2] 添加商品");
            System.out.println("[3] 查询商品");
            System.out.println("[0] 退出");
            int op = scanner.nextInt();
            flag = true;



            switch (op) {
                case 0:
                    System.out.println("退出");
                    bo = false;
                    break;
                case 1:
                    System.out.println("商品展示");
                    s.show();
                    break;
                case 2:

                    System.out.println("添加商品");
                    goods gs = new goods();
                    System.out.println("请输入商品id");
                    int id = scanner.nextInt();
                    if (s.searchId(id)) {
                        System.out.println("商品已存在,请重新添加商品");
                        break;
                    }
                    gs.setGid(id);
                    scanner.nextLine();
                    System.out.println("请输入商品名称");
                    gs.setGname(scanner.nextLine());
                    System.out.println("请输入商品价格");
                    gs.setGprice(scanner.nextInt());
                    System.out.println("请输入商品数量");
                    gs.setGamount(scanner.nextInt());
                    add.addNewGoods(gs);
                    break;
                case 3:
                    System.out.println("查询商品。请输入商品id或名称");
                    scanner.nextLine();
                    String ss  = scanner.nextLine();
                    try {
                        int i = Integer.parseInt(ss);
                        s.idToGoods(i);
                    }catch (Exception e){
                        s.idToGoods(ss);
                    }


            }

        }


//        int num = );
//

        s.show();

//        System.out.println(map);
    }
}
