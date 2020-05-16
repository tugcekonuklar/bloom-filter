package com.dkb.bloom.filter.service;

import java.util.BitSet;

public interface BloomFilterService {

    int getHashIndex(final String value, final int seed);

    BitSet add(final String value);

    boolean mightContain(final String word);
}
