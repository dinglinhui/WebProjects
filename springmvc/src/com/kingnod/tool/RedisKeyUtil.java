package com.kingnod.tool;


/**
 * Redis Key Definition
 * @author skylai
 *
 */
public abstract class RedisKeyUtil {

    public static final String CACHE_ROOT_NAME = "kingnod";
	public static final String CACHE_KEY_SEPARATOR = ":";
	public static final String CACHE_CPY="cpy";
	public static final String USER_ID="userId";
	
	
    /**
     * 拼接cpy key
     * @param keys
     * @return
     */
    public static String getKey(String... keys) {	
        StringBuilder sb = new StringBuilder("");
        sb.append(CACHE_ROOT_NAME).append(CACHE_KEY_SEPARATOR);
        int i = 0;
        for (String key : keys) {
            sb.append(key);
            if(i < keys.length - 1 ){
                 sb.append(CACHE_KEY_SEPARATOR);
            }
            i++;
        }
        return  sb.toString();
    }
   
	
	
	
}
