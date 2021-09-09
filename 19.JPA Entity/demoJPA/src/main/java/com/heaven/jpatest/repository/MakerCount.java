package com.heaven.jpatest.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MakerCount {
    private String maker;
    private Long count;
}
