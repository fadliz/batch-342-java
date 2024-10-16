package com.xa.batch342.dtos.responses;

import lombok.Data;

@Data
public class CategoryResponseDto {
    private String name;
    private String slug;
    private String description;
    private Long categoryId;    
}
