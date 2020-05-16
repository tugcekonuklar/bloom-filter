package com.dkb.bloom.filter.service;

import com.dkb.bloom.filter.domain.BloomFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.MurmurHash2;

import java.util.BitSet;
import java.util.stream.IntStream;

@Slf4j
public class BloomFilterServiceImpl implements BloomFilterService {

    private final BitSet bitSet;
    private BloomFilter filter;
    private final int numberHastFunction;

    public BloomFilterServiceImpl(final BloomFilter filter) {
        this.filter = filter;
        this.bitSet = new BitSet(filter.getSlot());
        this.numberHastFunction = calculateNumberOfHashFunction(filter.getSlot(), filter.getNumberOfItems());
    }

    @Override
    public BitSet add(final String value) {
        log.info("Adding value to bit Map : {}", value);
        IntStream.range(0, numberHastFunction)
                .forEach(num -> {
                    var index = getHashIndex(value, num);
                    bitSet.set(index, true);
                });
        return bitSet;
    }

    @Override
    public boolean mightContain(final String word) {
        log.info("Might contain value : {}", word);
        for (int i = 0; i < numberHastFunction; i++) {
            var index = getHashIndex(word, i);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getHashIndex(final String value, final int seed) {
        var valueByte = value.getBytes();
        var va = MurmurHash2.hash32(valueByte, valueByte.length, seed);
        return Math.abs(va) % filter.getSlot();
    }

    private int calculateNumberOfHashFunction(final int slot, final int numberOfItems) {
        return (int) ((slot / numberOfItems) * Math.log(2));
    }
}
