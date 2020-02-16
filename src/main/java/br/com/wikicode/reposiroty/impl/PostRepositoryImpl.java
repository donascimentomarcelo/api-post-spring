package br.com.wikicode.reposiroty.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import br.com.wikicode.domain.Post;
import br.com.wikicode.reposiroty.query.PostRepositoryQuery;

public class PostRepositoryImpl implements PostRepositoryQuery {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Post> findByTitle(String categoryId, String subcategoryId, String title) {
		Query query = new Query();
		
		@SuppressWarnings("unused")
		final StringBuilder builder = new StringBuilder();
		
		if (StringUtils.hasText(categoryId)) {
			query.addCriteria(Criteria.where("subcategory.category.id").is(categoryId));
		}
		
		if (StringUtils.hasText(subcategoryId)) {
			query.addCriteria(Criteria.where("subcategory.id").is(subcategoryId));
		}
		
		if (StringUtils.hasText(title)) {
			query.addCriteria(Criteria.where("title").is(title));
		}

		return mongoTemplate.find(query, Post.class);
	}

}
