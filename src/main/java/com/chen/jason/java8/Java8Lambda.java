package com.chen.jason.java8;

/**
 * Created on 2019/4/4. By CenJS
 */
public class Java8Lambda {
    final static String salutation = "Hello1! ";

    public static void main(String[] args) {
        Java8Lambda tester = new Java8Lambda();

        MathOperation addition = (int a,int b) -> a+b;
        MathOperation subtraction = (a,b) -> a-b;
        MathOperation multiplication = (int a,int b) -> {return a*b;};
        MathOperation division = (int a,int b) -> a/b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetService1 = message ->
                System.out.println(salutation + message);

        GreetingService greetService2 = (message) ->
                System.out.println(salutation + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

//        int num = 1;
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
//        num=5;


    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
