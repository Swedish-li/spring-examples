package com.lrs.idea;

import java.io.UnsupportedEncodingException;


public class IdeaKeyMapTest {
   /*
   * function:
   * parameter:
   * throw:
   * Created by Swedish-li
   */
    public void codeTemplatTest(){

        // 选中需要被包裹的代码 ctrl + alt + t
        try {
            int ab = 1;
            // ctrl + b 快速跳转到变量声明处
            System.out.println(ab++);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (true) {
            System.out.println("if template");
        } else {
            System.out.println("else");
        }


    }
    // alt + up/down 在定义类和定义的方法见快速跳转
    public void test(){
        try {
            String str = new String("str".getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // ctrl + p
        String str2 = new String();


    }
}
