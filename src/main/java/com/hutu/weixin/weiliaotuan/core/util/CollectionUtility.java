package com.hutu.weixin.weiliaotuan.core.util;

import java.util.Collection;

public class CollectionUtility {

	/**
	 * 判断指定collection是否是Null或者是空集合 Kevin 2014-09-15
	 * @param <T>
	 * 
	 * @param collection
	 *            待判断集合
	 * @return 操作成功返回True，否则返回False。
	 */
	public static <T> boolean isNullOrEmpty(Collection<T> collection) {
		if (collection == null)
			return true;
		return collection.isEmpty();
	}
}
