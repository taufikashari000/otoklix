package com.otoklix.payload;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
}
