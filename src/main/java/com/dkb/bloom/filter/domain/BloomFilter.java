package com.dkb.bloom.filter.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BloomFilter {
    private int slot;
    private int numberOfItems;
}
