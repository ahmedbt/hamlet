package ba.ahmed.boot.elastic;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

import static org.elasticsearch.node.NodeBuilder.*;


/**
 * Created by USER on 8/31/2017.
 */
/*@Configuration
@EnableElasticsearchRepositories(basePackages = "ba.ahmed.boot.elastic.repository")
@ComponentScan*/
public class Config {
/*
    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {


        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", "elasticsearch")
               // .put("local", false)
                .build();

        //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html

        TransportClient client = TransportClient.builder().settings(esSettings)
                .build();

        System.out.println("nodes " + client.listedNodes());

        client.addTransportAddress(
                  new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));


        return new ElasticsearchTemplate(client);
    }
    */
}
