package com.lrs.idea.think;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {

    final static String str ="Evening is full of the linnet's wings";
    @Test
    public void testFind(){
        Matcher matcher = Pattern.compile("\\w+").matcher(str);

        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        int count = 0;
        while (matcher.find(count)){
            System.out.print(matcher.group() + " ");
            count++;
        }
    }

    @Test
    public void testReFlags(){
        // 混合使用标记符
        Pattern pattern = Pattern.compile("^java",Pattern.MULTILINE|Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("java has regex\n" +
                "Java has regex\n" +
                "JAVA has pretty good regular expression\n" +
                "Regular expression are in Java");

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
