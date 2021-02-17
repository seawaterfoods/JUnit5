package TagExpressionsTest;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@Tags({@Tag("easy"),@Tag("hard")})
public class TagThirdTest {
    Logger log = Logger.getLogger(TagThirdTest.class.getName());

    @Test
    @Tag("important")
    @DisplayName("third-1")
    void third1Test() {
        log.info("third1Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Tag("production")
    @DisplayName("third-2")
    void third2Test() {
        log.info("third2Test");
        Assertions.assertEquals(2, Math.addExact(1, 1));
    }
}
