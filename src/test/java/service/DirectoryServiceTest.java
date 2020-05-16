package service;

import com.dkb.bloom.filter.service.DictionaryService;
import com.dkb.bloom.filter.service.DictionaryServiceImpl;
import org.junit.Test;

import static domain.DictionaryFixture.someDictionary;
import static org.junit.Assert.assertEquals;

public class DirectoryServiceTest {
    private DictionaryService service = new DictionaryServiceImpl();

    @Test
    public void shouldLoadDictionarySuccessfully() {
        final var expectedResult = someDictionary();
        final var result = service.load("wordlist_test.txt");
        assertEquals(expectedResult, result);
    }
}
