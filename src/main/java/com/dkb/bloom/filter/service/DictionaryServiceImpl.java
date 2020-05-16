package com.dkb.bloom.filter.service;

import com.dkb.bloom.filter.domain.Dictionary;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class DictionaryServiceImpl implements DictionaryService {

    @Override
    public Dictionary load(String fileName) {
        log.info("Read from file : {}", fileName);
        try {
            final var path = Paths.get(getClass().getClassLoader().getResource(fileName).getPath());
            return Dictionary.builder()
                    .words(Files.readAllLines(
                            Paths.get(getClass().getClassLoader().getResource(fileName).getPath()),
                            StandardCharsets.ISO_8859_1)
                    ).build();

        } catch (IOException e) {
            log.error("Dictionary Service load method throws an error : {}", e.getMessage());
        }
        return Dictionary.builder().build();
    }
}
