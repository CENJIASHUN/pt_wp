package com.chen.jason.webxml.test;

import com.chen.jason.webxml.MobileCodeWS;
import com.chen.jason.webxml.MobileCodeWSSoap;

public class WSModelTest {
    public static void main(String[] args) {
        MobileCodeWS mobileCodeWS=new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();
        String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("15868857183", null);
        System.out.println(mobileCodeInfo);
    }
}
