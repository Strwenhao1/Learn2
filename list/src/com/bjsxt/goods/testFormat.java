package com.bjsxt.goods;

import java.awt.*;

public class testFormat {
    public static void main(String[] args) {

        System.out.printf("%8s%6s%6s%6s","商品id","商品价格","商品名称","商品数量");
        System.out.println();
        String s = "ss";
        goods good1 = new goods(1, 198, "礼盒月饼", 88);
        System.out.format("%8s%9s%8s", good1.getGid(), good1.getGprice(), good1.getGname());
//        System.out.printf("%6s     %6s     %6s   %6s",good1.getGid(),good1.getGprice(),good1.getGname(),good1.getGamount());
    }
}
