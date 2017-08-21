package org.jon.lv.mapping;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.jon.lv.ESRestClient;

import java.io.IOException;
import java.util.Collections;

/**
 * @Package org.jon.lv.mapping.BaseMapping
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/18 16:42
 * version V1.0.0
 */
public class BaseMapping {

    public final static String QUERY_ALL_INDEX = "/_cat/indices?v";

    public static String getQueryAllIndex(RestClient restClient) throws IOException {
        Response response =  restClient.performRequest("GET", QUERY_ALL_INDEX,
                Collections.singletonMap("pretty", "true"));

        String str = EntityUtils.toString(response.getEntity());
        return str;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getQueryAllIndex(ESRestClient.getClient()));
    }
}
