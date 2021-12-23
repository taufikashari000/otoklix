package com.otoklix.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Date published_at;
    private Date created_at;
    private Date updated_at;

    public PostDto(Long id, String title, String content, Date published_at, Date created_at, Date updated_at){
        this.id = id;
        this.title = title;
        this.content = content;
        this.published_at = published_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
