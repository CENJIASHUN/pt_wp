package com.chen.jason.test;

/**
 * Created on 2019/7/2. By CenJS
 */
public class qiertest {
    public static void main(String[] args) {
        String a = "啊,不,从,的;额";
        String b = "啊,不,从,的;;额";
        String c = "啊,不,从,的;;;;;额";
        String d = "啊,不,从,的;;;";
        String e = "啊,不,从,的;;;;;;";
        String[] x = d.split(";;");
        for (int i=0;i<x.length;i++){
            System.out.println(i+"=====>"+x[i]);
        }


    }
}
