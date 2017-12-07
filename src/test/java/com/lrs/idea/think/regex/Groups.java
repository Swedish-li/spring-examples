package com.lrs.idea.think.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    static public final String POEM = "おどけた ふり してたら\n" +
            "いつ のまにか 笑いながら 泣いてた\n" +
            "知りたい の 知らない世界 を\n" +
            "陽 の 当たる フロア を探して\n" +
            "あさき ゆめみ し夢から 目覚めて\n" +
            "踊る の なら 自由に\n" ;

    public static void main(String[] args) {
        Matcher matcher = Pattern
                //?m : 序列开头模式标记
                // 圆括号表示分组
                .compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
                .matcher(POEM);
        while (matcher.find()){
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.print("[" + matcher.group(i) + "]");
            }
            System.out.println();
        }

    }
}
