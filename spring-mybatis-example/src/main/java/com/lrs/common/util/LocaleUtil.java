package com.lrs.common.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * 国际化信息 ISO Language
 * Code：http://www.loc.gov/standards/iso639-2/php/English_list.php
 * 
 * @author Swedish-li
 * 
 */
public class LocaleUtil {
	private MessageSource message;
	private final static Locale VIETNAM;
	public static final String VI_VN = "vi_VN";
	public static final String ZH_CN = "zh_CN";
	public static final String EN_US = "en_US";
	static {
		VIETNAM = new Locale("vi", "VN");
	}

	public void setMessage(MessageSource message) {
		this.message = message;
	}

	public String getMessage(String key, String language) {
		return message.getMessage(key, null, getLocale(language));
	}

	public String getMessage(String key, String language, Object... args) {
		return message.getMessage(key, args, getLocale(language));
	}

	private Locale getLocale(String language) {
		if (VI_VN.equals(language)) {
			return VIETNAM;
		} else if (ZH_CN.equals(language)) {
			return Locale.CHINA;
		} else if (EN_US.equals(language)) {
			return Locale.US;
		} else {
			throw new IllegalArgumentException("系统未配置语言：" + language);
		}

	}
}
