package com.poc.graphqlserver.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookInput {
    private String title;
    private String publisher;
    private Long authorId;
}
