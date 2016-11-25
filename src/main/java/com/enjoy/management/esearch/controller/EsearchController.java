package com.enjoy.management.esearch.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.client.transport.TransportClient.Builder;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.management.esearch.util.EsearchUtils;

@RestController
@RequestMapping(value="/esearch")
public class EsearchController {

	@RequestMapping(value="add")
	public String add() throws UnknownHostException{
		Settings settings = Settings.settingsBuilder().put("cluster.name", "node1").build();
        Builder builder = TransportClient.builder().settings(settings);
        Client client = builder.build().addTransportAddress(
				new InetSocketTransportAddress(InetAddress
						.getByName("127.0.0.1"), 9300));

		List<String> jsonData = EsearchUtils.getJsonData();
		for(int i=0;i<jsonData.size();i++){
			IndexResponse response = client.prepareIndex("blog","article").setSource(jsonData.get(i)).get();
			if(response.isCreated()){
				System.out.println("crate success!");
			}
		}
		client.close();
		return "search";
	}
}
