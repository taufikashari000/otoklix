package com.otoklix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "otoklix")
@Data
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Column(name = "content")
    @JsonProperty("content")
    private String content;

    @Column(name = "published_at")
    @JsonProperty("published_at")
    private Date published_at;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Date created_at;

    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Date updated_at;
}
