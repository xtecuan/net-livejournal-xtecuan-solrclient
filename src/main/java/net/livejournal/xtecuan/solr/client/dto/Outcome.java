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
package net.livejournal.xtecuan.solr.client.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.apache.solr.client.solrj.beans.Field;

/**
 *
 * @author xtecuan
 */
public class Outcome implements Serializable {

    @Field
    private String author;
    //OUT-ID
    @Field
    private String custom1;
    //OUT-TYPE
    @Field
    private String custom2;
    @Field
    private String custom3;
    @Field
    private String custom4;
    //OUT-ID
    @Field
    private Integer key;
    //Query
    @Field
    private String mime;
    //new Date()
    @Field
    private Date modified;
    //Sum of bytes of spell
    @Field
    private Long size;
    //OUT-ID OUT-NUMBER_OUT_ID name name objetives comments location_description
    @Field
    private List<String> spell;
    //spell 0 100 chars
    @Field
    private String summary;
    //Output Name
    @Field
    private String title;
    //out_id
    @Field
    private Integer uid;
    @Field
    private String url;

    public Outcome() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public List<String> getSpell() {
        return spell;
    }

    public void setSpell(List<String> spell) {
        this.spell = spell;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.uid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Outcome other = (Outcome) obj;
        if (!Objects.equals(this.uid, other.uid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Outcome{" + "author=" + author + ", custom1=" + custom1 + ", custom2=" + custom2 + ", custom3=" + custom3 + ", custom4=" + custom4 + ", key=" + key + ", mime=" + mime + ", modified=" + modified + ", size=" + size + ", spell=" + spell + ", summary=" + summary + ", title=" + title + ", uid=" + uid + '}';
    }

}
