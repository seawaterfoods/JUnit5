import org.junit.jupiter.api.*;

import java.util.Locale;
import java.util.logging.*;

public class AssumptionsTest {
    Logger log =Logger.getLogger(AssumptionsTest.class.getName());

    @Test
    public void doCalculatorLocaleIsTAIWAN() {
        // Assume that the current locale is TAIWAN
        Locale currentLocale = Locale.getDefault();
        Assumptions.assumeFalse(currentLocale.equals(Locale.TAIWAN), "Locale need not TAIWAN!");

        // Test Calculator
        int num1 = 2;
        int num2 = 2;
        int expected1 = 4;
        int expected2 = 3;

        int actual = AssertionCalculator.add(num1, num2);

        Assertions.assertEquals(expected1, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") not equal " + expected1);
        Assertions.assertNotEquals(expected2, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") equal " + expected2);
    }

    @Test
    public void doCalculatorLocaleNonTAIWAN() {
        // Assume that the current locale is TAIWAN
        Locale currentLocale = Locale.getDefault();
        Assumptions.assumeTrue(currentLocale.equals(Locale.TAIWAN), "Locale need TAIWAN!");

        // Test Calculator
        int num1 = 2;
        int num2 = 2;
        int expected1 = 4;
        int expected2 = 3;

        int actual = AssertionCalculator.add(num1, num2);

        Assertions.assertEquals(expected1, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") not equal " + expected1);
        Assertions.assertNotEquals(expected2, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") equal " + expected2);
    }

    @Test
    public void whenLocaleIsTAIWANLogMsgAndDoCalculator() {
//        如果第一個參數為true就會執行Executable的execute方法，但是要注意assumingThat方法的特點：不拋出異常，因此其所在的方法不會被跳過，
//        這是和assumeTrue相比最大的區別(assumeTrue一旦參數為false就會拋出異常，其所在方法就被標記為跳過)：
        Locale currentLocale = Locale.getDefault();
        Assumptions.assumingThat(currentLocale.equals(Locale.TAIWAN),
                () -> {
                    log.info("當Locale是TAIWAN時才打印。");
                }
        );
        // Test Calculator
        int num1 = 2;
        int num2 = 2;
        int expected1 = 4;
        int expected2 = 3;

        int actual = AssertionCalculator.add(num1, num2);
//
        Assertions.assertEquals(expected1, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") not equal " + expected1);
        Assertions.assertNotEquals(expected2, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") equal " + expected2);
    }
}
