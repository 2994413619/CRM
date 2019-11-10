package club.ityuchao.utils;

import org.apache.commons.lang3.StringUtils;

public class IsNull {

	//isNotEmpty和isNotBlank的区别
	public static void main(String[] args) {
		String str1 = null;
		String str2 = "";
		String str3 = "  ";
		String str4 = "  1  ";
		System.out.println("StringUtils.isNotEmpty():");
		System.out.println(StringUtils.isNotEmpty(str1));
		System.out.println(StringUtils.isNotEmpty(str2));
		System.out.println(StringUtils.isNotEmpty(str3));
		System.out.println(StringUtils.isNotEmpty(str4));
		System.out.println("StringUtils.isNotBlank():");
		System.out.println(StringUtils.isNotBlank(str1));
		System.out.println(StringUtils.isNotBlank(str2));
		System.out.println(StringUtils.isNotBlank(str3));
		System.out.println(StringUtils.isNotBlank(str4));
	}
}
