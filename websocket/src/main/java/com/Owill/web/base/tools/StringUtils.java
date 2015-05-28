/**
 * Copyright 2014 零志愿工作室 (http://www.0will.com). All rights reserved.
 * File Name: BaseEntity.java
 * Author: chenlong
 * Encoding UTF-8
 * Version: 1.0
 * Date: 2014年12月4日
 * History:	
 */
package com.Owill.web.base.tools;


/**
 * @author chenlong（chenlongwill@163.com）
 * @version Revision: 1.0.0 Date: 2014年12月4日
 */
public class StringUtils {

	/**
	 * 判断非空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotNull(String string) {
		return ((string != null) && (!string.equals("")));
	}

	/**
	 * 判断非空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string) {
		return isNotNull(string);
	}

	/**
	 * 判断�?
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNull(String string) {
		return !isNotNull(string);
	}

	/**
	 * 判断�?
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		return !isNotEmpty(string);
	}

	/**
	 * 将int数组转换成字符串,使用separator字符串分隔符
	 * 
	 * @param src
	 * @param separator
	 * @return
	 */
	public static String concatArray(int[] src, String separator) {

		if (src.length == 0) {
			return null;
		}

		if (src.length <= 1) {
			return String.valueOf(src[0]);
		}

		StringBuilder builder = new StringBuilder();

		builder.append(src[0]);

		for (int i = 1; i < src.length; i++) {
			builder.append(separator).append(src[i]);
		}

		return builder.toString();
	}

	/**
	 * Base64 加密
	 * 
	 * @param string
	 * @return
	 */
	public static String Base64Encrypt(String string) {
		return Base64.encode(string.getBytes());
	}

	/**
	 * Base64解密
	 * 
	 * @param string
	 * @return
	 */
	public static String Base64Decrypt(String string) {
		return new String(Base64.decode(string));
	}

	/**
	 * MD5加密
	 * 
	 * @param string
	 * @return
	 */
	public static String MD5Encrypt(String string) {
		return MD5.getMD5String(string);
	}

	/**
	 * 随机字符
	 * 
	 * @param length
	 * @return
	 */
	public static String RandomString(int length) {
		double time = System.currentTimeMillis();
		time = time * Math.random();
		StringBuffer result = new StringBuffer(MD5Encrypt(String.valueOf(time)));
		if (length < 32)
			return result.substring(0, length);
		if (length == 32)
			return result.toString();
		return result.append(RandomString(length - 32)).toString();
	}

	/**
	 * 判断字符串是否是正整�?
	 * */
	public static boolean  isFigure(String strs){
        try{
        	if(strs.substring(1).equals("0")||(strs.substring(1).equals("-"))){
        		return false;
        	}else{
	            int num=Integer.valueOf(strs);
	            num=num+1;
	            return true;
        	}
        }catch(Exception e){
            return false;
        }
    }
}