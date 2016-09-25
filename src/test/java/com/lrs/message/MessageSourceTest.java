package com.lrs.message;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lrs.common.util.LocaleUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class MessageSourceTest {
	@Autowired
	private MessageSource resources;

	@Test
	public void testMessage() {
		// org.springframework.core.ResolvableTypeProvider.class;

		String strCn = resources.getMessage("something", null, Locale.CHINA);
		String strEn = resources.getMessage("something", null, Locale.ENGLISH);
		// String strVn = resources.getMessage("key", null, "vi");
		System.out.println("中文：" + strCn);
		System.out.println("英文：" + strEn);
	}

	@Autowired
	private LocaleUtil local;

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
}
