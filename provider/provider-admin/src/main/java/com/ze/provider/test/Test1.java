package com.ze.provider.test;

import java.util.*;

/**
 * @Date 2019/11/28 9:39
 * @Author GaoZien
 * @Desc TODO
 */
public class Test1 {

    final static String salutation = "Hello!1 ";

    public static void main(String[] args) {
//        Test1 test1 = new Test1();
//        // 类型声明
//        MathOperation addtion = (int a, int b) -> a + b;
//
//        // 不用类型声明
//        MathOperation subtract = (a, b) -> a - b;
//
//        // 大括号中的返回语句
//        MathOperation multiplication = (int a, int b) -> { return a * b; };
//
//        // 没有大括号及返回语句
//        MathOperation division = (int a, int b) -> a / b;
//
//        System.out.println("10 + 5 = " + test1.operate(10, 5, addtion));
//        System.out.println("10 - 5 = " + test1.operate(10, 5, subtract));
//        System.out.println("10 x 5 = " + test1.operate(10, 5, multiplication));
//        System.out.println("10 / 5 = " + test1.operate(10, 5, division));
//
//        // 不用括号
//        GreetingService greetingService = message -> System.out.println("Hello " + message);
//
//        // 用括号
//        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
//
//        greetingService.sayMessage("Runoob");
//        greetService2.sayMessage("Google");
//
//        // 引用全局的final变量
//        GreetingService greetService1 = message ->
//                System.out.println(salutation + message);
//        greetService1.sayMessage("Runoob1");
//
//        // 引用局部的final变量
//        final int num = 1;
//        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
//        s.convert(2);  // 输出结果为 3

//        final Car car = car

                List<String> list = new ArrayList<>();
        list.add("001");
        list.add("002");
        list.add("003");
        list.add("004");
        list.add("005");
        list.add("006");
        list.add("007");
        list.add("008");
        list.add("009");
        list.add("010");
        list.add("011");


        luckeyDraw(list, 7);

        for (String per :  list){
            System.out.println("sheng"+per);
        }

    }

    private static void luckeyDraw(List<String> leftList,Integer luckyNum) {
        List<String> resultList = new ArrayList<>();
        int max=leftList.size(),min=1;
//        int luckeyNum = 7;
        if(max < luckyNum){
            System.out.println("中奖人数太多");
        }
        for (int j = 0; j < luckyNum; j++){
                max=leftList.size();
                int ran2 = (int) (Math.random()*(max-min)+min);
                int i = 1;
                String integer = leftList.get(ran2);
            leftList.remove(ran2);
                System.out.println("中奖人："+integer);
//                System.out.println("中奖人1："+leftList.get(ran2));


//            Iterator<String> iterator = leftList.iterator();
//                 while (iterator.hasNext()) {
//                     String integer = iterator.next();
//                            if (i == ran2) {
//                                System.out.println("中奖人："+integer);
//                                resultList.add(integer);
//                                  iterator.remove();
//                             }
//                     i++;
//                 }
        }
        System.out.println("结束抽奖！！！");

    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface  GreetingService {
        void sayMessage(String message);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }


    private int operate(int a, int b, MathOperation mathOperation){
        return  mathOperation.operation(a, b);
    }

    private static void testSort(){
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");
        Test1 test1 = new Test1();
        test1.sortUsingJava7(names1);
        System.out.println(names1);
        test1.sortUsingJava8(names2);
        System.out.println(names2);
    }

    private  void  sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    private  void  sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }


}
