/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.mobile_widgets_variables.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * ArticleTags generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`article_tags`")
@IdClass(ArticleTagsId.class)
public class ArticleTags implements Serializable {

    private Integer articleId;
    private Integer tagId;
    private String blank;

    @Id
    @Column(name = "`article_id`", nullable = false, scale = 0, precision = 10)
    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Id
    @Column(name = "`tag_id`", nullable = false, scale = 0, precision = 10)
    public Integer getTagId() {
        return this.tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Column(name = "`blank`", nullable = true, length = 255)
    public String getBlank() {
        return this.blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleTags)) return false;
        final ArticleTags articleTags = (ArticleTags) o;
        return Objects.equals(getArticleId(), articleTags.getArticleId()) &&
                Objects.equals(getTagId(), articleTags.getTagId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArticleId(),
                getTagId());
    }
}

