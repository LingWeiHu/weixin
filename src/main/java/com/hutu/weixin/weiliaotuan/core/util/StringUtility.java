package com.hutu.weixin.weiliaotuan.core.util;

public class StringUtility {

	/**
	 * 判断指定value是否是Null或者是空字符串 Kevin 2014-09-15
	 * 
	 * @param value
	 *            待判断字符串
	 * @return 操作成功返回True，否则返回False。
	 */
	public static boolean IsNullOrEmpty(String value) {
		if (value == null)
			return true;
		if ("".equals(value))
			return true;
		return false;
	}
}
