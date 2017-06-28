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

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.livejournal.xtecuan.solr.client.dto.Outcome;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author xtecuan
 */
public class Updater {

    public static void main1(String[] args) throws MalformedURLException, SolrServerException, IOException {

        SolrServer server = new CommonsHttpSolrServer("http://knlsystem.iadb.org:8983/solr/outcome");
        Collection<SolrInputDocument> docs = new ArrayList<>();
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("key", "100000");
        doc.addField("title", "Sample Output xtecuan");
        doc.addField("mime", "Query");
        doc.addField("author", "julianr");
        doc.addField("modified", new Date());
        doc.addField("uid", "100000");
        doc.addField("url", "/");
        doc.addField("size", "Sample Output xtecuan".getBytes().length);

        docs.add(doc);
        server.add(docs);
        server.commit();

    }

    public static SolrInputDocument fromOutDoc2InputDoc(SolrDocument myDoc) {
        SolrInputDocument doc = new SolrInputDocument();
        for (Map.Entry<String, Object> entry : myDoc) {
            doc.addField(entry.getKey(), entry.getValue());
        }
        return doc;
    }

    public static void main3(String[] args) throws MalformedURLException, SolrServerException, IOException {
        SolrServer server = new CommonsHttpSolrServer("http://knlsystem.iadb.org:8983/solr/outcome");
        SolrQuery query = new SolrQuery();
        query.setQuery("uid:101000");

        QueryResponse rsp = server.query(query);

        SolrDocumentList docs = rsp.getResults();

        Collection<SolrInputDocument> docsToModify = new ArrayList<>();
        System.out.println("Result search");
        for (SolrDocument doc : docs) {
            System.out.println(doc);
        }

//        SolrDocument myDoc = docs.get(0);
//
//        myDoc.setField("custom2", "OUT_GENERAL_EVENT_XTE");
//
//        docsToModify.add(fromOutDoc2InputDoc(myDoc));
//        server.add(docsToModify);
//        server.commit();
       // System.out.println("21224 OUT-21224 Gestión de riesgos (8a Edición) Gestión de riesgos (8a Edición) Este tercer curso de".length());

    }

    public static void main(String[] args) {

        SolrClient client = new SolrClient("localhost", 8984, "solr", "outcome");

        Outcome out = new Outcome();
        out.setUid(101000);
        out.setKey(101000);
        out.setCustom1("OUT-101000");
        out.setAuthor("julianr");
        out.setCustom2("OUT_EXTERNAL_EVENT1");
        out.setMime("Query");
        out.setModified(new Date());
        List<String> spell = new ArrayList<>();
        spell.add("Some sample text for output document");
        out.setSpell(spell);
        out.setSize(Long.valueOf(spell.get(0).getBytes().length));
        out.setSummary(spell.get(0));
        out.setTitle("Output Xtecuan prueba");
        out.setUrl("/");
        client.addDocument(out,"outcome");

    }

}
