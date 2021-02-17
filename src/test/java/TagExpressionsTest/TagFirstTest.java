package TagExpressionsTest;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@Tag("first")
public class TagFirstTest {
    Logger log = Logger.getLogger(TagFirstTest.class.getName());

    @Test
    @Tags({@Tag("easy"),@Tag("important")})
    @DisplayName("first-1")
    void first1Test() {
        log.info("first1Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @DisplayName("first-2")
    void first2Test() {
        log.info("first2Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Tag("hard")
    @DisplayName("first-3")
    void first3Test() {
        log.info("first3Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }
}
