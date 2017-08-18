package com.blueocean.common.constant;

public class PharmacyConstant {

	/**
	 * 检测类型
	 * 
	 * @author zhangyalin
	 *
	 */
	public static interface SiteType {
		/** 药店 */
		public final static int Shop = 1;

	}

	public static interface YesOrNo {
		public final static String YES = "1";
		public final static String NO = "0";
	}

	public static String SiteTypeName(int type) {
		String value = "";
		switch (type) {
		case 1:
			value = "药店";
			break;
		}
		return value;
	}
}
