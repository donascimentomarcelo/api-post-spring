package br.com.wikicode.reposiroty.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.reposiroty.query.SubcategoryRepositoryQuery;

public class SubcategoryRepositoryImpl implements SubcategoryRepositoryQuery {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Subcategory> filter(String name, String categoryId) {
		Query query = new Query();
		
		@SuppressWarnings("unused")
		final StringBuilder builder = new StringBuilder();
		
		if (StringUtils.hasText(name)) {
			query.addCriteria(Criteria.where("name").is(name));
		}
		
		if (StringUtils.hasText(categoryId)) {
			query.addCriteria(Criteria.where("category.id").is(categoryId));
		}
		
		
		return mongoTemplate.find(query, Subcategory.class);
	}

}
