package domain;

import com.dkb.bloom.filter.domain.BloomFilter;

public class BloomFilterFixture {
    public static BloomFilter someBloomFilter() {
        return BloomFilter.builder()
                .numberOfItems(10)
                .slot(20)
                .build();
    }
}
