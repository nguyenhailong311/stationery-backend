package com.example.stationeryecommerce.entity.request;

import lombok.Data;

@Data
public class CommentSending {
    private String comment;
    private Long user_id;
    private Long product_id;
    private int star;
}
