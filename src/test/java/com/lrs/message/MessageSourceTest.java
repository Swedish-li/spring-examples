package com.lrs.message;

import com.lrs.common.util.LocaleUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.NumberFormat;
import java.util.Locale;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Locale
 * <p>
 * 1、一种语言 ，2、一个位置(可选)， 3、一个变量(可选)
 * <p>
 * ISO-369-1,语言代码，ISO-3166-1,国家代码
 *
 * @author Swedish-li
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class MessageSourceTest {
    @Autowired
    private MessageSource resources;
    @Autowired
    private LocaleUtil local;

    @Test
    public void testMessage() {
        // org.springframework.core.ResolvableTypeProvider.class;

        String strCn = resources.getMessage("something", null, Locale.CHINA);
        String strEn = resources.getMessage("something", null, Locale.ENGLISH);
        // String strVn = resources.getMessage("key", null, "vi");
        System.out.println("中文：" + strCn);
        System.out.println("英文：" + strEn);
    }

    @Test
    public void testLocal() {

        String vi = local.getMessage("something", "vi_VN");
        System.out.println("越南=>" + vi);
        String cn = local.getMessage("something", "zh_CN");
        System.out.println("中国=>" + cn);
        String en = local.getMessage("something", "en_US");
        System.out.println("英语（美国）=>" + en);
    }

    @Test
    // 越南=VN 越南文=vi
    public void testLocalInJava() {
        Locale[] localeList = Locale.getAvailableLocales();
        for (int i = 0; i < localeList.length; i++) {
            System.out.println(localeList[i].getDisplayCountry() + "="
                    + localeList[i].getCountry() + " "
                    + localeList[i].getDisplayLanguage() + "="
                    + localeList[i].getLanguage());
        }

    }

    @Test
    public void testLocalWithArgs() {
        String vi = local.getMessage("best.player", LocaleUtil.VI_VN, "tom");
        System.out.println(vi);
        String cn = local.getMessage("best.player", LocaleUtil.ZH_CN, "tom");
        System.out.println(cn);
        String en = local.getMessage("best.player", LocaleUtil.EN_US, "tom");
        System.out.println(en);
    }

    // 数字格式化
    @Test
    public void testNumberFormat() {
        double num = 123456.79;
        Locale deLocale = Locale.GERMANY;
        NumberFormat deFormat = NumberFormat.getCurrencyInstance(deLocale);

        Locale chLocale = Locale.CHINA;
        NumberFormat chFormat = NumberFormat.getCurrencyInstance(chLocale);
        String deRs = deFormat.format(num);
        String chRs = chFormat.format(num);

        assertThat(deRs, equalTo("123.456,79 €"));
        assertThat(chRs, equalTo("￥123,456.79"));

    }
}
