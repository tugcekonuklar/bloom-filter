package com.dkb.bloom.filter.service;

import com.dkb.bloom.filter.domain.Dictionary;

public interface DictionaryService {
    Dictionary load(final String fileName);
}
