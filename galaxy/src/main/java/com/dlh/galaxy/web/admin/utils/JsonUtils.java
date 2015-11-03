/**
 * 
 */
package com.dlh.galaxy.web.admin.utils;

/**
 * @author dinglinhui
 */
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JsonUtils {

	public static <K, V> String toJson(Map<K, V> obj) {
		String jsonString = "";
		try {
			if (obj == null) {
				return "";
			}
			StringWriter sw = new StringWriter();
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(gen, obj);
			jsonString = sw.toString();
			sw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}

		return jsonString;
	}

	public static String toJson(Object object) {
		String json = "";
		try {
			if (object == null) {
				return "";
			}
			StringWriter sw = new StringWriter();
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
			ObjectMapper mapper = new ObjectMapper();

			mapper.writeValue(gen, object);

			json = sw.toString();
			sw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			json = "";
		}
		return json;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(String json) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (json == null || json.equals("")) {
				return null;
			}

			ObjectMapper objectMapper = new ObjectMapper();
			result = objectMapper.readValue(json, Map.class);
			if (result == null) {
				return new HashMap<String, Object>();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("deprecation")
	public static <T> T toObject(String json, Class<T> clazz) {
		T obj = null;
		try {
			if (json == null || json.equals("")) {
				return null;
			}
			JsonFactory jsonFactory = new MappingJsonFactory();
			JsonParser jsonParser = jsonFactory.createJsonParser(json);
			ObjectMapper mapper = new ObjectMapper();
			mapper.getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			obj = mapper.readValue(jsonParser, clazz);

		} catch (Exception ex) {
			ex.printStackTrace();
			obj = null;
		}
		return obj;

	}

	@SuppressWarnings("deprecation")
	public static <T> List<T> toList(String json, Class<T> clazz) {
		if (json == null || json.equals("")) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<T> list = new ArrayList<T>();
		try {
			JavaType type = mapper.getTypeFactory().constructParametricType(List.class, clazz);
			list = mapper.readValue(json, type);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
