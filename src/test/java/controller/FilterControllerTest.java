package controller;

import com.dkb.bloom.filter.controller.Controller;
import com.dkb.bloom.filter.controller.FilterController;
import org.junit.Assert;
import org.junit.Test;


public class FilterControllerTest {

    private Controller controller = new FilterController();

    @Test
    public void shouldMightContainSuccessfully() {
        controller.execute();
        final var result = controller.mightContain("Tugce");
        Assert.assertEquals(true, result);
    }
}
