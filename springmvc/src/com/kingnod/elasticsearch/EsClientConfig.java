package com.kingnod.elasticsearch;

import java.util.LinkedHashSet;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.config.ClientConstants;

public class EsClientConfig {
	public static JestClient jestClient;
	public static Client client;

	static  {
		//Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch").build();
		Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch").build();
        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
    }
	 
	private static ClientConfig clientConfig() {
		// es的服务端地址,暂时我是用我虚拟机的(ubuntu)做服务器
		String connectionUrl = "http://127.0.0.1:9200";// 一般都是9200端口
		ClientConfig clientConfig = new ClientConfig();
		// 当你用集群时,就有可能会有多个es的服务端,这里我暂时没有集群
		LinkedHashSet servers = new LinkedHashSet();
		servers.add(connectionUrl);
		clientConfig.getServerProperties().put(ClientConstants.SERVER_LIST,
				servers);
		clientConfig.getClientFeatures().put(ClientConstants.IS_MULTI_THREADED,
				false);
		return clientConfig;
	}

	/**
	 * 获取一个jest的对象
	 * 
	 * @return
	 */
	public static JestClient jestClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setClientConfig(clientConfig());
		if (jestClient == null) {
			jestClient = factory.getObject();
		}
		return jestClient;
	}
}
