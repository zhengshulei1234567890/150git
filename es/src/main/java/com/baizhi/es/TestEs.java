package com.baizhi.es;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import javax.sound.sampled.Port;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestEs {


    @Test
    public void test1() throws Exception {
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.234.40"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        System.out.println("========创建索引=========");
        //CreateIndexResponse indexResponse = transportClient.admin().indices().prepareCreate("dangdang").execute().get();
        //System.out.println(indexResponse.index());

        System.out.println("==========创建类型指定映射==============");
        XContentBuilder mappingBuilder = XContentFactory.jsonBuilder();
        mappingBuilder.startObject()
                .startObject("properties")
                .startObject("name")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()
                .startObject("age")
                .field("type", "integer")
                .endObject()
                .startObject("sex")
                .field("type", "keyword")
                .endObject()
                .startObject("content")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest putMappingRequest = new PutMappingRequest("dangdang").type("book").source(mappingBuilder);
        transportClient.admin().indices().putMapping(putMappingRequest).get();
    }


    @Test
    public void test2() throws Exception {
        /**
         * 创建索引(自动生成文档id)
         * @throws IOException
         */
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.234.40"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject()
                .field("name", "总国人")
                .field("age", 23)
                .field("sex", "男")
                .field("context", "中国攻占全地球")
                .endObject();
        IndexResponse indexResponse = transportClient.prepareIndex("dangdang", "book").setSource(xContentBuilder).get();
        System.out.println(indexResponse.status());

    }


    @Test
    public void test3() throws Exception {
        /**
         * 创建索引(手动生成文档id)
         * @throws IOException
         */
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.234.40"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject()
                .field("name", "中国人")
                .field("age", 23)
                .field("sex", "男")
                .field("content", "他是一个中国人,这个中国人怎么样,挺好的").endObject();
        IndexResponse indexResponse = transportClient.prepareIndex("dangdang", "book", "1").setSource(xContentBuilder).get();
        System.out.println(indexResponse.status());
    }


    @Test
    public void test4() throws Exception {
        /**
         * 更新一条记录
         * @throws IOException
         */
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.234.40"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        XContentBuilder source = XContentFactory.jsonBuilder();
        source.startObject().field("name", "小黑是垃圾").endObject();
        UpdateResponse updateResponse = transportClient.prepareUpdate("dangdang", "book", "1").setDoc(source).execute().get();
        System.out.println(updateResponse.status());
    }


    @Test
    public void test5() throws Exception {
        /**
         * 删除一条索引
         * @throws IOException
         */
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.234.40"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        DeleteResponse deleteResponse = transportClient.prepareDelete("dangdang", "book", "1").get();
        System.out.println(deleteResponse.status());
    }


    @Test
    public void test6() throws Exception {
        /**
         * 批量更新
         * @throws IOException
         */
        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("192.168.234.40"), 9300);
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(transportAddress);
        //添加第一条记录
        IndexRequest request1 = new IndexRequest("dangdang","book","1");
        request1.source(XContentFactory.jsonBuilder().startObject().field("name","中国科技").field("age",23).field("sex","男").field("content","这是个好人").endObject());


        //添加第二条记录
        IndexRequest request2 = new IndexRequest("dangdang","book","2");
        request2.source(XContentFactory.jsonBuilder().startObject().field("name","中国之声").field("age",23).field("sex","男").field("content","这是一个好的声音").endObject());

        //更新记录
      //  UpdateRequest updateRequest = new UpdateRequest("dangdang","book","1");
      //  updateRequest.doc(XContentFactory.jsonBuilder().startObject().field("name","中国力量").endObject());

        //删除一条记录
      //  DeleteRequest deleteRequest = new DeleteRequest("dangdang","book","1");

       BulkResponse bulkItemResponses = transportClient.prepareBulk().add(request1).add(request2).get();
       // BulkItemResponse[] items = bulkItemResponses.getItems();
      // for (BulkItemResponse item : items) {
        //   System.out.println(item.status());
      // }
    }




}