package com.bjsxt.goods;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class store {
    public static Map<Integer, goods> map;
    public static Map<Integer, goods> carMap;
    public static addGoods add = new addGoods();

    public static void main(String[] args) throws IOException {
        com c = new com();
        map = new TreeMap<Integer, goods>();
        carMap = new TreeMap<Integer, goods>();

        BufferedReader br = new BufferedReader(new FileReader("d:/Mapgoods.txt"));
        String str1 = null;

        while ((str1 = br.readLine()) != null) {
            String[] st = str1.split(" ");
            map.put(Integer.parseInt(st[0]), new goods(Integer.parseInt(st[0]), Integer.parseInt(st[1]), st[2], Integer.parseInt(st[3])));
        }
        br.close();

        BufferedReader br1 = new BufferedReader(new FileReader("d:/Cargoods.txt"));
        String str2 = null;

        while ((str2 = br1.readLine()) != null) {
            String[] st = str2.split(" ");
            carMap.put(Integer.parseInt(st[0]), new goods(Integer.parseInt(st[0]), Integer.parseInt(st[1]), st[2], Integer.parseInt(st[3])));
        }
        br1.close();


        Scanner scanner = new Scanner(System.in);
        Search s = new Search();
        Boolean bo = true;
        Boolean flag = true;

        while (bo) {
            System.out.println("[1] 商品展示");
            System.out.println("[2] 添加商品");
            System.out.println("[3] 查询商品");
            System.out.println("[4] 添加商品到购物车");
            System.out.println("[5] 显示购物车");
            System.out.println("[6] 修改购物车商品");
            System.out.println("[0] 退出");
            int op = scanner.nextInt();
            flag = true;

            switch (op) {
                case 0:
                    System.out.println("正在退出，谢谢使用");
                    bo = false;
                    break;
                case 1:
                    System.out.println("*************商 品 展 示**************");
                    s.show(map);
                    break;
                case 2:
                    System.out.println("*************添 加 商 品*************");
                    goods gs = new goods();
                    System.out.println("请输入商品id");
                    int id = scanner.nextInt();
                    if (s.searchId(map, id)) {
                        System.out.println("*****商品已存在,请重新添加商品*******");
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
                    System.out.println("查询商品,请输入商品id或名称");
                    scanner.nextLine();
                    String ss = scanner.nextLine();
                    try {
                        int i = Integer.parseInt(ss);
                        if (!s.idToGoods(map, i)) {
                            System.out.println("**********指定Id商品不存在**********");
                        }
                    } catch (Exception e) {
                        if (!s.nameToGoods(map, ss)) {
                            System.out.println("**********指定名称商品不存在**********");
                        }
                    }
                    break;
                case 4:
                    System.out.println("*************添加商品到购物车**************");
                    s.show(map);
                    System.out.println("*************请输入添加商品ID**************");
                    scanner.nextLine();
                    String addg = scanner.nextLine();
                    try {
                        int i = Integer.parseInt(addg);
                        if (!s.idToGoods(map, i)) {
                            System.out.println("**********指定Id商品不存在**********");
                        } else {
                            System.out.println("*************请输入添加商品数量**************");
                            int carAddNum = scanner.nextInt();
                            goods cargood = map.get(i);
                            if (cargood.getGamount() < carAddNum) {
                                System.out.println("商品数量不足，请重新添加");
                                break;
                            }

                            if (cargood.getGamount() == carAddNum) {
                                carMap.put(i, map.get(i));
                                map.remove(Integer.valueOf(i));
                                break;
                            }
                            if(s.searchId(carMap,i)){
                                int amou = carMap.get(Integer.valueOf(i)).getGamount();
                                carMap.put(i, new goods(i, cargood.getGprice(), cargood.getGname(), amou+carAddNum));
                                map.replace(i, new goods(i, cargood.getGprice(), cargood.getGname(), cargood.getGamount() - carAddNum));
                                break;
                            }
                            carMap.put(i, new goods(i, cargood.getGprice(), cargood.getGname(), carAddNum));
                            map.replace(i, new goods(i, cargood.getGprice(), cargood.getGname(), cargood.getGamount() - carAddNum));

                        }

                    } catch (Exception e) {
                        System.out.println("输入错误，请重新添加");
                    }
                    break;
                case 5:
                    System.out.println("*************显示购物车**************");
                    s.show(carMap);
                    break;
                case 6:
                    System.out.println("*************修改购物车商品**************");
                    s.show(carMap);
                    System.out.println("请输入所需要修改的商品id");
                    int carId = scanner.nextInt();
                    System.out.println("请输入所需要修改的商品数量");
                    int carNum = scanner.nextInt();

                    if((!map.containsKey(Integer.valueOf(carId)))&&carMap.containsKey(Integer.valueOf(carId))){
                        goods ggs = carMap.get(Integer.valueOf(carId));
                        map.put(carId, new goods(carId, ggs.getGprice(), ggs.getGname(),0));

                    }
                    int sum = map.get(carId).getGamount() + carMap.get(carId).getGamount();
                    if (carNum > sum) {
                        System.out.println("商品数量不足，请重新修改");
                        break;
                    }
                    if (carNum == sum) {
                        map.remove(Integer.valueOf(carId));
                    }else {
                        map.get(carId).setGamount(sum - carNum);
                    }
                    carMap.get(carId).setGamount(carNum);
                    if(carNum==0){
                        carMap.remove(Integer.valueOf(carId));
                    }
                    break;
                case 7:

                    break;

            }

        }

        ShopCar.saveMap(map);
        ShopCar.saveCar(carMap);

    }
}


