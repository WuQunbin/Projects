package com.gs.testDemo;

import java.util.Date;

/**
 * @Author:伍群斌
 * @Description:
 * @Date:2018/5/8 22:22
 */
public class Test extends Date{
    public static void main(String[] args){
        new Test().test();
    }
    public void test(){
        System.out.println(super.getClass().getName());
    }
}
