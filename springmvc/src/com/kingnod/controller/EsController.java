package com.kingnod.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;









import javax.servlet.http.HttpUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.kingnod.entity.News;
import com.kingnod.service.SearchService;
/**
 * elasticsearch 搜索引擎
 * @author JCN
 *
 */
@RestController
@RequestMapping(value="es")
public class EsController {

	@Autowired
	private SearchService searchService;
	/**
	 * 跳转到新闻主页
	 * @param mv
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView newsIndex(ModelAndView mv){
		mv.setViewName("view/news");
		return mv;
	}
	/**
	 * 保存新闻搜索的内容并放入到elasticSearch中
	 * @param content
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="save/new/search",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> saveSearchContent(@RequestParam("searchContent")String searchContent){
		Map<String,Object> map = new HashMap<String, Object>();
		boolean b = true;
		if(StringUtils.isNotBlank(searchContent)){
			 b =	searchService.saveSearchContent(searchContent,"index","fulltext");
			searchService.search(searchContent,"index","fulltext");
		}else{
			searchService.search(searchContent,"index","fulltext");
		}
		map.put("status",b);
		return map;
	}
	@RequestMapping(value="set")
	public void buildSearchIndex() {
		searchService.builderSearchIndex();
	}
	@RequestMapping(value="get")
	public void searchNews() {
		String param ="搜索";
		List<News> news = searchService.searchsNews(param);
		//System.out.println("id   标题                                           内容");
		for (int i = 0; i < news.size(); i++) {
			News article = news.get(i);
			//System.out.println(article.getId() + "   " + article.getTitle() + "   " + article.getContent());
			//http://restapi.amap.com/v3/geocode/geo?key=e94bb541df355c19a09611cc6e5483b1&s=rsv3&city=&address=深圳市联想大厦
		}
	}
	@RequestMapping("map")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String,Object> getLocation(@RequestParam(value="address",required=true)String address){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		RestTemplate rest = new RestTemplate();
		String url ="http://restapi.amap.com/v3/geocode/geo?key=e94bb541df355c19a09611cc6e5483b1&s=rsv3&city=&address="+address;
		Map<String,Object> rs = rest.getForObject(url, Map.class);
		if(Integer.parseInt((String)rs.get("count"))>=1 && rs.containsKey("geocodes")){
			list = (List<Map<String, Object>>) rs.get("geocodes");
			String location =(String)list.get(0).get("location");
			System.out.println(location);
		}
		return rs;
	}
}
