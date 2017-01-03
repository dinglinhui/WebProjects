package com.journaldev.java8.loop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForLoop {

	public List<Article> articles;

	public Article getFirstJavaArticle() {

		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				return article;
			}
		}

		return null;
	}

	public List<Article> getAllJavaArticles() {

		List<Article> result = new ArrayList<>();

		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				result.add(article);
			}
		}

		return result;
	}

	public Map<String, List<Article>> groupByAuthor() {

		Map<String, List<Article>> result = new HashMap<>();

		for (Article article : articles) {
			if (result.containsKey(article.getAuthor())) {
				result.get(article.getAuthor()).add(article);
			} else {
				ArrayList<Article> articles = new ArrayList<>();
				articles.add(article);
				result.put(article.getAuthor(), articles);
			}
		}

		return result;
	}

	public Set<String> getDistinctTags() {

		Set<String> result = new HashSet<>();

		for (Article article : articles) {
			result.addAll(article.getTags());
		}

		return result;
	}
}
