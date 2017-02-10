package com.kingnod.service;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import com.kingnod.dto.NewsDTO;
import com.kingnod.elasticsearch.EsClientConfig;
import com.kingnod.entity.News;



/**
 * es简单服务接口
 * 
 * @author hk
 * 
 *      
 *         2013-1-12 下午11:47:16
 */
@Service
public class SearchService {

	private static JestClient jestClient = EsClientConfig.jestClient();
	private static Client client = EsClientConfig.client;
	int num = 10000;
	public static long SIZE =10;

	/**
	 * 创建es news索引
	 */
	public void builderSearchIndex() {
		long start = System.currentTimeMillis();
		try {
			// 如果索引存在,删除索引
			DeleteIndex deleteIndex = new DeleteIndex("news");
			jestClient.execute(deleteIndex);

			// 创建索引
			CreateIndex createIndex = new CreateIndex("news");
			jestClient.execute(createIndex);
			// Bulk 两个参数1:索引名称2:类型名称(用文章(article)做类型名称)
			Bulk bulk = new Bulk("news", "article");
			// 添加添加100万条假数据去服务端(ES)
			for (int i = 0; i < num; i++) {
				News news = new com.kingnod.entity.News();
				//news.setId(i + 1);
				news.setTitle("elasticsearch RESTful搜索引擎-(java jest 使用[入门])" + (i + 1));
				news.setContent("做个搜索就那么难"
						+ (i + 1));
				bulk.addIndex(new Index.Builder(news).build());
			}
			jestClient.execute(bulk);
		} catch (Exception e) {
			jestClient.shutdownClient();
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("创建索引时间:数据量是  " + num + "记录,共用时间 -->> " + (end - start) + " 毫秒");
	}
	/**
	 * 搜索新闻
	 * 
	 * @param param
	 * @return
	 */
	public List<News> searchsNews(String param) {
		try {
			long start = System.currentTimeMillis();
			//MatchQueryBuilder  qb = new MatchQueryBuilder("content",param);
			QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(param);
			queryBuilder.field("content");
			queryBuilder.field("title");
			SearchRequestBuilder  builder = client.prepareSearch("news");
			builder.setTypes("article");
			builder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
			builder.setQuery(queryBuilder);
			builder.setFrom(0);
			builder.setSize((int)SIZE);
			builder.setExplain(false);//是否显示匹配的过程，设置为true会增加内存开销
			SearchResponse response = builder.execute().actionGet();
		//	QueryBuilder builder = QueryBuilders.termQuery("content",param);
		//	SearchResponse response = client.prepareSearch("news").setTypes("article").setSearchType(SearchType.DEFAULT).setQuery(builder).setFrom(0).setSize(100).setExplain(true).execute().actionGet();
			
			SearchHits hits = response.getHits(); 
			
			long end = System.currentTimeMillis();
			System.out.println("在" + num + "条记录中,搜索新闻,共用时间 -->> " + (end - start) + " 毫秒");
			for(int i=0 ;i<SIZE;i++){
			Map<String,Object> map = hits.getAt(i).getSource();
			System.out.println("i="+i+"     "+map.get("id")+"       "+map.get("title")+"     "+map.get("content"));
			}
			Search search = new Search(Search.createQueryWithBuilder(queryBuilder.toString()));
			search.addIndex("news");
			search.addType("article");
			JestResult result = jestClient.execute(search);
		    return result.getSourceAsObjectList(News.class);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*-----------------------------------------------------------------------------------------------------------------------*/
	/*-----------------------------------------------下面是新闻模块关于搜索引擎的调用---------------------------------------------------*/
	/*-----------------------------------------------------------------------------------------------------------------------*/
	/**
	 * 将客户搜索的内容存入搜索引擎中
	 * @param content 搜索内容
	 */
	public boolean saveSearchContent(String content,String index,String type){
		try {
			CreateIndex createIndex = new CreateIndex(index);
			jestClient.execute(createIndex);
			// Bulk 两个参数1:索引名称2:类型名称(用文章(article)做类型名称)
			Bulk bulk = new Bulk(index,type);
			News news = new News();
			news.setId(getNewsId());
			news.setTitle(content);
			news.setCreateDate(new Date());
			news.setContent(content);
			bulk.addIndex(new Index.Builder(news).build());
			jestClient.execute(bulk);
			return true;
		} catch (Exception e) {
			jestClient.shutdownClient();
			return false;
		}
	}
	/**
	 * 获取搜索新闻ID(当前时间戳+5位随机数)
	 * @return
	 */
	public Long getNewsId(){
		Long id= null;
		id=	System.currentTimeMillis()+(long)(Math.random()*100000);
		return id;
	}
	/**
	 * 检索新闻获取满足条件的前十条数据
	 * @param content 搜索内容
	 * @return
	 */
	public List<NewsDTO> search(String content,String index,String type){
		List<NewsDTO> list = new ArrayList<NewsDTO>();
		if(StringUtils.isNotBlank(content)){//当有搜索条件的时候
			MultiMatchQueryBuilder qb = QueryBuilders.multiMatchQuery(content,"content").analyzer("ik");
			//QueryBuilder qb = QueryBuilders.termsQuery("content",content);
			SearchResponse response = client.prepareSearch(index)
					.setTypes(type)
					.setFrom(0)
					.setSize((int)SIZE)
					.addSort("createDate",SortOrder.DESC)
					.setExplain(true)
				  //  .setQuery(QueryBuilders.matchQuery("content",content))
				    .setQuery(qb)
				    .addAggregation(
				            AggregationBuilders.terms("titleAgg").field("title").size(5)
				    )
				    .execute().actionGet();
			SearchHits hits = response.getHits();
			Terms terms = response.getAggregations().get("titleAgg");
			for (Bucket b : terms.getBuckets()) {
			     System.out.println(b.getKey()+"*******"+b.getDocCount());
			}
			//long total =hits.getTotalHits();
			long total =hits.getHits().length;
			SIZE = total>=SIZE?SIZE:total;
			for(int i=0 ;i<SIZE;i++){
			Map<String,Object> map = hits.getAt(i).getSource();
				System.out.println("有条件   i="+i+"     "+map.get("id")+"       "+map.get("title")+"     "+map.get("content"));
			}
			   
		}else{//没有搜索条件的时候
			SearchResponse response = client.prepareSearch(index)
					.setTypes(type)
					.setFrom(0)
					.setSize((int)SIZE)
					.addSort("createDate",SortOrder.DESC)
					.setExplain(false)
				    .setQuery(QueryBuilders.matchAllQuery())
				    .execute().actionGet();
			SearchHit[] hit = response.getHits().getHits();
			long total =hit.length;
			for(int i=0 ;i<total;i++){
				Map<String,Object> map = hit[i].getSource();
				News news = new News();
				try {
					BeanUtils.populate(news, map);
					System.out.println(news.getContent()+"  ^^^^^    "+news.getId());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("没条件   i="+i+"     "+map.get("id")+"       "+map.get("title")+"     "+map.get("content"));
			}
		}
		return list;
	}
}
