package com.enjoy.management.esearch.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import com.enjoy.management.esearch.entity.Blog;

public class EsearchUtils {

	public static List<String> getJsonData() {
		List<String> list = new ArrayList<String>();
		String data1 = EntityToJsonString(new Blog(1, "git简介", "2016-06-19",
				"SVN与Git最主要的区别..."));
		String data2 = EntityToJsonString(new Blog(2, "Java中泛型的介绍与简单使用",
				"2016-06-19", "学习目标 掌握泛型的产生意义..."));
		String data3 = EntityToJsonString(new Blog(3, "SQL基本操作", "2016-06-19",
				"基本操作：CRUD ..."));
		String data4 = EntityToJsonString(new Blog(4, "Hibernate框架基础",
				"2016-06-19", "Hibernate框架基础..."));
		String data5 = EntityToJsonString(new Blog(5, "Shell基本知识",
				"2016-06-19", "Shell是什么..."));
		list.add(data1);
		list.add(data2);
		list.add(data3);
		list.add(data4);
		list.add(data5);
		return list;
	}
	
	// Java实体对象转json对象
	public static String EntityToJsonString(Blog blog){
	        String jsonData = null;
	        try {
	            XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
	            jsonBuild.startObject().field("id", blog.getId()).field("title", blog.getTitle())
	                    .field("posttime", blog.getPosttime()).field("content",blog.getContent()).endObject();

	            jsonData = jsonBuild.string();
	            //System.out.println(jsonData);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return jsonData;
	    }
	
}
