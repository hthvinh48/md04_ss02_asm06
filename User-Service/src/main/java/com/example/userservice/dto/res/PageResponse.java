package com.example.userservice.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> data;
    private PageMeta meta;
}
