package TagExpressionsTest;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@Tag("second")
public class TagSecondTest {
    Logger log = Logger.getLogger(TagSecondTest.class.getName());

    @Test
    @DisplayName("second-1")
    void second1Test() {
        log.info("second1Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Tag("easy")
    @DisplayName("second-2")
    void second2Test() {
        log.info("second2Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Tag("hard")
    @Tag("important")
    @DisplayName("second-3")
    void second3Test() {
        log.info("second3Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }
}
