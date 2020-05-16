package domain;

import com.dkb.bloom.filter.domain.Dictionary;

import java.util.List;

public class DictionaryFixture {
    public static Dictionary someDictionary() {
        return Dictionary.builder()
                .words(List.of(
                        "John",
                        "Jack",
                        "Tugce",
                        "Paris",
                        "Berlin",
                        "Istanbul",
                        "Apple",
                        "Cat",
                        "Dog",
                        "Table"))
                .build();
    }
}
