package com.kingnod.redis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.kingnod.entity.JcnUser;
import com.kingnod.tool.RedisKeyUtil;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String, Map<String,String>> redisTemplate;
	
	@Autowired
	private RedisTemplate<String, Long> redisLongTemplate;
	
	@Autowired
	private RedisTemplate<String, Integer> redisIntTemplate;
	
	@Autowired
	private RedisTemplate<String,String> RedisStringTemplate;
	
	@Autowired
	private RedisTemplate<String,JcnUser> redisObjectTemplate;
	
	public List<Long> putUserId(Long userId) {
		System.out.println("***tem*"+redisLongTemplate);
		//StringBuilder sb = new StringBuilder();
		//sb.append(RedisKeyUtil.CACHE_ROOT_NAME).append(RedisKeyUtil.CACHE_KEY_SEPARATOR);
		//sb.append(RedisKeyUtil.USER_ID);
		String key=RedisKeyUtil.getKey(RedisKeyUtil.CACHE_CPY,RedisKeyUtil.USER_ID);
		redisLongTemplate.opsForList().leftPush(key.toString(), userId);
		List<Long>	list = redisLongTemplate.opsForList().range(key, 0,redisLongTemplate.opsForList().size(key));
		
		return list;
	 }
	public List<String> findByKey(String key){
		//List<String> list = redisStringTemplate.opsForList().range(key, 0,redisStringTemplate.opsForList().size(key));
		return null;
	}
	@SuppressWarnings("unchecked")
	public Map<Object, Object> findValue(String key){
		//RedisStringTemplate.opsForValue().set(key,key);
		JcnUser user = new JcnUser();
		user.setCreateDate(new Date());
		user.setLastUpdateDate(new Date());
		user.setName("lulu");
		user.setPassword("1234");
		Map map = new HashMap<String,String>();
		map.put("create_date", DateFormatUtils.format(user.getCreateDate(),"yyyy-MM-dd"));
		map.put("update_date", DateFormatUtils.format(user.getLastUpdateDate(),"yyyy-MM-dd HH:mm:ss"));
		map.put("name",user.getName());
		map.put("password",user.getPassword());
		redisTemplate.opsForHash().putAll(key, map);
		//redisObjectTemplate.opsForValue().set(key,user);保存对象，该对象将被编译成字符串保存在redis,但日期属性无法保存，估计是无法序列化
		//RedisStringTemplate.opsForValue().get(key);
	 return	redisTemplate.opsForHash().entries(key);
	}
}
