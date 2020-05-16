package com.dkb.bloom.filter.controller;

import com.dkb.bloom.filter.domain.BloomFilter;
import com.dkb.bloom.filter.service.BloomFilterService;
import com.dkb.bloom.filter.service.BloomFilterServiceImpl;
import com.dkb.bloom.filter.service.DictionaryService;
import com.dkb.bloom.filter.service.DictionaryServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilterController implements Controller {

    private static final String FILE_NAME = "wordlist.txt";

    private DictionaryService dictionaryService;
    private BloomFilterService bloomFilterService;
    private int slot;

    public FilterController() {
        dictionaryService = new DictionaryServiceImpl();

    }

    @Override
    public void execute() {
        log.info("Filter controller start to execute");
        final var dictionary = dictionaryService.load(FILE_NAME);
        final var bloomFilter = BloomFilter.builder()
                .numberOfItems(dictionary.getWords().size())
                .slot(slot)
                .build();
        bloomFilterService = new BloomFilterServiceImpl(bloomFilter);
        dictionary.getWords().stream()
                .forEach(word -> bloomFilterService.add(word));
    }

    @Override
    public boolean mightContain(final String value) {
        log.info("Search for value : {}", value);
        return bloomFilterService.mightContain(value);
    }

    public void setSlot(final int slot) {
        this.slot = slot;
    }

}
