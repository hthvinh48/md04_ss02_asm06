package com.example.userservice.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageMeta {
    private long total;
    private int page;
    private int size;
    private boolean first;
    private boolean last;
}
