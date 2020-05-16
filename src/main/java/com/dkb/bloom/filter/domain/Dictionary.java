package com.dkb.bloom.filter.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Dictionary {
    private List<String> words;
}
