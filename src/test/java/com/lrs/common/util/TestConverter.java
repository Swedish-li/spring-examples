package com.lrs.common.util;

import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

public class TestConverter {
	@Test
	public void testCoverter() {
		String[] strs = { "2016-07", "2016-07-26 18:20:03", "2016-07-26",
				"2016-07-26 18:20" };
		for (String str : strs) {
			ConvertUtils.register(new DateConverter(), Date.class);
			Date date = (Date) ConvertUtils.convert(str, Date.class);
			// /Date date =(Date)new DateConverter().convert(Date.class,
			// "2016-12-11 18:00:15");
			System.out.println(date);
		}

		String str = (String) ConvertUtils.convert(new Date(), String.class);
		System.out.println(str);
	}
	@Test
	public void testCovert() {
		Object ob = ConvertUtils.convert(new Date(), String.class);
		System.out.println(ob);
	}
}
