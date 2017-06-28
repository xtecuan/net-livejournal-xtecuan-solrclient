/*
 * Copyright 2017 xtecuan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.livejournal.xtecuan.solr.client;

import java.net.MalformedURLException;
import net.livejournal.xtecuan.solr.client.dto.Outcome;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;

/**
 *
 * @author xtecuan
 */
public class SolrClient {

    public static final String HTTP = "http://";
    public static final String SERVER = "knlsystem.iadb.org";
    public static final Integer PORT = 8983;
    public static final String CONTEXT_PATH = "solr";
    public static final String OUTCOME_COLLECTION = "outcome";
    private SolrServer server;
    private SolrServer outcomeServer;
    private String host;
    private Integer port;
    private String contextPath;
    private String defaultCollection;

    public SolrClient() {
        this.host = SERVER;
        this.port = PORT;
        this.contextPath = CONTEXT_PATH;
        this.defaultCollection = OUTCOME_COLLECTION;
    }

    public SolrClient(String host, Integer port, String contextPath, String defaultCollection) {
        this.host = host;
        this.port = port;
        this.contextPath = contextPath;
        this.defaultCollection = defaultCollection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getDefaultCollection() {
        return defaultCollection;
    }

    public void setDefaultCollection(String defaultCollection) {
        this.defaultCollection = defaultCollection;
    }

    public String getBaseUrl() {
        return HTTP + getHost() + ":" + getPort() + "/" + getContextPath();
    }

    public String getCollectionURL(String collection) {
        return getBaseUrl() + "/" + collection;
    }

    public String getOutcomeURL() {
        return getCollectionURL(OUTCOME_COLLECTION);
    }

    public SolrServer getServer(String collection) throws MalformedURLException {
        if (server == null) {
            return new CommonsHttpSolrServer(getCollectionURL(collection));
        } else {
            return server;
        }
    }

    public SolrServer getOutcomeServer() throws MalformedURLException {
        if (outcomeServer == null) {
            return new CommonsHttpSolrServer(getOutcomeURL());
        } else {
            return outcomeServer;
        }
    }

    public void addOutcomeDocument(Outcome doc) {
        try {
            UpdateResponse response = getOutcomeServer().addBean(doc);
            getOutcomeServer().commit();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("Error creating a document in outcome collection: " + e.getMessage());
        }
    }

    public void addDocument(Object doc, String collection) {
        try {
            UpdateResponse response = getServer(collection).addBean(doc);
            getServer(collection).commit();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println("Error creating a document in " + collection + " collection: " + e.getMessage());
        }
    }

}
