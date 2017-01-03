package com.journaldev.java8.loop;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream implements ArticleI {

	public List<Article> articles;

	@Override
	public Optional<Article> getFirstJavaArticle() {
		return articles.stream()
				.filter(article -> article.getTags().contains("Java"))
				.findFirst();
	}

	@Override
	public List<Article> getAllJavaArticles() {
		return articles.stream()
				.filter(article -> article.getTags().contains("Java"))
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, List<Article>> groupByAuthor() {
		return articles.stream().collect(
				Collectors.groupingBy(Article::getAuthor));
	}

	@Override
	public Set<String> getDistinctTags() {
		return articles.stream().flatMap(article -> article.getTags().stream())
				.collect(Collectors.toSet());
	}

}
