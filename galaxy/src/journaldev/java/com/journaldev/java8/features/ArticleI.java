package com.journaldev.java8.features;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ArticleI {

	public Optional<Article> getFirstJavaArticle();

	public List<Article> getAllJavaArticles();

	public Map<String, List<Article>> groupByAuthor();

	public Set<String> getDistinctTags();
}
