package service;

import com.dkb.bloom.filter.service.BloomFilterService;
import com.dkb.bloom.filter.service.BloomFilterServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static domain.BloomFilterFixture.someBloomFilter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BloomFilterServiceTest {

    private BloomFilterService service;

    @Before
    public void setUp() {
        service = new BloomFilterServiceImpl(someBloomFilter());
    }

    @Test
    public void shouldAddValue() {
        final var expectedBitSet = new BitSet();
        expectedBitSet.set(13, true);
        final var result = service.add("someValue");
        assertEquals(expectedBitSet, result);
    }

    @Test
    public void shouldMightContainTrue() {
        service.add("someValue");
        final var result = service.mightContain("someValue");
        assertTrue(result);
    }

    @Test
    public void shouldMightContainFalse() {
        service.add("someValue");
        final var result = service.mightContain("someOtherValue");
        assertFalse(result);
    }

    @Test
    public void shouldGetIndexWorksSuccessfully() {
        final var result = service.getHashIndex("someValue", 1);
        assertEquals(9, result);
    }


}
