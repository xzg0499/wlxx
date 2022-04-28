package com.xzg.wlxx.poker;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;

/**
 * @author xzgang0499
 * @date 2022-04-22
 * @since jdk1.8
 */
public class Demo {
    private static List<Integer> cards = new ArrayList<Integer>(){
        {
            for(int i=0;i<52;i++){
                add((i/4)+1);
            }
        }
    };
    private static List<Integer> p1 = new ArrayList<Integer>();
    private static List<Integer> p2 = new ArrayList<Integer>();
    private static List<Integer> p3 = new ArrayList<Integer>();
    private static List<Integer> dump = new ArrayList<>();

    public static void main(String[] args) {
        play();
        List<Integer> pn = new ArrayList<>();
        do{
            List<Integer> l1 = Room.scanner(p1);
            List<Integer> l2 = Room.scanner(p2);
            List<Integer> l3 = Room.scanner(p3);
            pn = ArrayUtil.clone(l3);
            soutP();
        }while (hasNext());
    }

    public static Boolean hasNext(){
        if(p1.size() >0 && p2.size() > 0){
            return true;
        }
        if(p1.size() >0 && p3.size() > 0){
            return true;
        }
        if(p2.size() >0 && p3.size() > 0){
            return true;
        }
        return false;
    }

    public static void soutP(){
        System.out.println("p1："+p1+"数组长度："+p1.size());
        System.out.println("p2："+p2+"数组长度："+p2.size());
        System.out.println("p3："+p3+"数组长度："+p3.size());
    }


    public static class Room{

        public static void remove(List<Integer> l,List<Integer> p){
            l.forEach(p::remove);
            dump.addAll(l);
        }


        public static List<Integer> scanner(List<Integer> p){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            List<Integer> ls = new ArrayList<>();
            if(!s.contains(",") && !s.matches("\\d*")){
                System.out.println("输入数字，并以英文都好（,）分隔");
                ls = scanner(p);
            }else if("*".equals(s)){
                return ls;
            }
            String[] sArr = s.split(",");
            for(String e : sArr){
                if(StrUtil.isNotBlank(e) && e.matches("\\d*")){
                    ls.add(Integer.parseInt(e));
                }else{
                    System.out.println("请输入数字");
                    ls = scanner(p);
                    break;
                }
            }
            if(!p.containsAll(ls)){
                System.out.println("请输入数组中有的数字");
                ls = scanner(p);
            }
            return ls;
        }

    }

    public static class Adapter{
        public static class OneCard extends Adapter{

        }
    }

    public static class Judg{

    }

    public static void play(){
        Init.outOfOrder();
        Init.distributed();
    }

    public static class Init{
        public static void distributed(){
            for(int i=0;i<cards.size();i++){
                if(i%3.0==0){
                    p1.add(cards.get(i));
                }else if(i%3.0==1){
                    p2.add(cards.get(i));
                }else if(i%3.0==2){
                    p3.add(cards.get(i));
                }
            }
            System.out.println("分配后数组:");
            soutP();
        }

        public static void outOfOrder(){
            System.out.println("乱序前数组："+cards);
            System.out.println("乱序前数组长度："+cards.size());
            Collections.shuffle(cards);
            System.out.println("乱序后数组："+cards);
        }
    }
}
