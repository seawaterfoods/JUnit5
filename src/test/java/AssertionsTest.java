import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AssertionsTest {

    static int[] actualIntArr;
    static int[] expectedIntArr;
    static List<String> actualStrList;
    static List<String> expectedStrList;

    @BeforeAll
    public static void init() {
        actualIntArr = new int[]{1, 2, 3, 4};
        expectedIntArr = new int[]{1, 2, 3, 4};

        actualStrList = new ArrayList<>();
        expectedStrList = new ArrayList<>();
        actualStrList.add("1");
        actualStrList.add("2");
        actualStrList.add("3");
        actualStrList.add("4");

        expectedStrList.add("1");
        expectedStrList.add("2");
        expectedStrList.add("3");
        expectedStrList.add("4");
    }

    @Test
    public void objectComparisonCase() {
//        public static void assertEquals(Object expected, Object actual)
//        public static void assertEquals(Object expected, Object actual, String message)
//        public static void assertEquals(Object expected, Object actual, Supplier<String< messageSupplier)
//        public static void assertNotEquals(Object expected, Object actual)
//        public static void assertNotEquals(Object expected, Object actual, String message)
//        public static void assertNotEquals(Object expected, Object actual, Supplier<String> messageSupplier)

        //assertEquals & assertNotEquals斷言物件(參數)是否不同(相同)，可以在比較後自訂錯誤提示

        int num1 = 2;
        int num2 = 2;
        int expected1 = 4;
        int expected2 = 3;

        int actual = AssertionCalculator.add(num1, num2);

        Assertions.assertEquals(expected1, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") not equal " + expected1);
        Assertions.assertNotEquals(expected2, actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") equal " + expected2);

    }

    @Test
    public void directJudgmentCase() {
//        public static void assertTrue(boolean condition)
//        public static void assertTrue(boolean condition, String message)
//        public static void assertTrue(boolean condition, Supplier<String> messageSupplier)
//        public static void assertTrue(BooleanSupplier booleanSupplier)
//        public static void assertTrue(BooleanSupplier booleanSupplier, String message)
//        public static void assertTrue(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier)
//        public static void assertFalse(boolean condition)
//        public static void assertFalse(boolean condition, String message)
//        public static void assertFalse(boolean condition, Supplier<String> messageSupplier)
//        public static void assertFalse(BooleanSupplier booleanSupplier)
//        public static void assertFalse(BooleanSupplier booleanSupplier, String message)
//        public static void assertFalse(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier)

        int num1 = 2;
        int num2 = 2;
        int expected1 = 4;
        int expected2 = 3;

        int actual = AssertionCalculator.add(num1, num2);

        //直接斷言該值是否為true
        Assertions.assertTrue(expected1 == actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") == " + expected1 + "is false");
        //直接斷言該值是否為false
        Assertions.assertFalse(expected2 == actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") == " + expected2 + "is true");

    }

    @Test
    public void nullJudgmentCase() {
//        public static void assertNotNull(Object actual)
//        public static void assertNotNull(Object actual, String message)
//        public static void assertNotNull(Object actual, Supplier<String> messageSupplier)
//        public static void assertEquals(Object actual)
//        public static void assertEquals(Object actual, String message)
//        public static void assertEquals(Object actual, Supplier<String> messageSupplier)

        //assertNull斷言物件為Null & assertNotNull斷言物件不為Null

        int num1 = 2;
        int num2 = 2;

        int actual = AssertionCalculator.add(num1, num2);

        Assertions.assertNotNull(actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") is null");
        Object nullActual = null;
        Assertions.assertNull(nullActual, "nullActual is not null");
    }

    @Test
    public void assertSameCase() {
//        public static void assertNotSame(Object unexpected,　Object actual)
//        public static void assertNotSame(Object unexpected,　Object actual, String message)
//        public static void assertNotSame(Object unexpected,　Object actual, Supplier<> messageSupplier)
//        public static void assertSame(Object expected, Object actual)
//        public static void assertSame(Object expected, Object actual, String message)
//        public static void assertSameObject expected, (Object actual, Supplier<String> messageSupplier)

        // assertSame()方法斷言所期望的和實際的指的是完全相同的對象。
        // assertNotSame()聲明預期和實際不要引用同一對象。
        List<String> cloneStrList = actualStrList;

        Assertions.assertSame(cloneStrList, actualStrList, "actualStrList & cloneStrList refer to the not same object");
        Assertions.assertNotSame(expectedStrList, actualStrList, "actualStrList & expectedStrList refer to the same object");
    }

    @Test
    public void assertTimeoutJudgmentCase() {
//        public static void assertTimeout(Duration timeout, Executable executable)
//        public static void assertTimeout(Duration timeout, Executable executable, String message)
//        public static void assertTimeout(Duration timeout, Executable executable, Supplier<String> messageSupplier)

//        assertTimeout()和assertTimeoutPreemptively()都用於測試長時間運行的任務。
//        如果測試用例中的給定任務花費的時間超過指定的持續時間，則測試將失敗。
//        這兩種方法之間唯一的區別是在assertTimeoutPreemptively()，如果超過了超時，將搶先中止Executable或ThrowingSupplier執行。
//        如果使用assertTimeout()，則不會終止Executable或ThrowingSupplier。

        int num3;
        //This will pass
        num3 = Assertions.assertTimeout(Duration.ofMinutes(1), () -> {
            return -1;
        }, "Timeout Duration.ofMinutes(1)");
        System.out.println("num3:"+num3);


        //This will fail 還是會return
        num3 = Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(200);
            return 1;
        }, "Timeout Duration.ofMillis(100)");
        System.out.println("num3:"+num3);

        //This will fail 不會return
        num3 = Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(200);
            return 2;
        }, "Timeout Duration.ofMillis(100)");
        System.out.println("num3:"+num3);
    }

    @Test
    public void assertThrowsCase() {
//        public static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable)
//        public static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable, String message)
//        public static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable, Supplier<String> messageSupplier)

        //AassertThrows() & assertDoesNotThrow()，可以對方法拋出異常的斷言測試(就是看他是不是拋出正確(錯誤)的Exception)
        //AassertThrows　如果引發的異常與設定的異常相同，則這一步的斷言成功並可以返回一個異常

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("error message");
        });
    }

    @Test
    public void assertDoesNotThrowCase() {
//        主要用來判定被測試方法是否拋出了異常，如果拋出異常則斷言失敗，無異常拋出則斷言成功。

//        public static void assertDoesNotThrow(Executable executable)
//        public static void assertDoesNotThrow(Executable executable, String message)
//        public static void assertDoesNotThrow(Executable executable, Supplier<String> messageSupplier)
//        public static <T> T assertDoesNotThrow(ThrowingSupplier<T> supplier)
//        public static <T> T assertDoesNotThrow(ThrowingSupplier<T> supplier, String message)
//        public static <T> T assertDoesNotThrow(ThrowingSupplier<T> supplier, Supplier<String> messageSupplier)

        //the following will succeed
        Assertions.assertDoesNotThrow(() -> methodMustNotThrow(2,2), "fail with methodMustNotThrow message: Exception");
        //the following will fail
        Assertions.assertDoesNotThrow(() -> {
            methodMustNotThrow(2,0);
        }, "Fail: must not trow");
    }

    void methodMustNotThrow(int num1, int num2) {
        try {
            int result = num1 / num2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("The numB not allowed to '0'!!");
        }
    }

    @Test
    public void arrayEqualsCase() {
//        public static void assertArrayEquals(int[] expected, int[] actual)
//        public static void assertArrayEquals(int[] expected, int[] actual, String message)
//        public static void assertArrayEquals(int[] expected, int[] actual, Supplier<String> messageSupplier)

        //斷言數組是否與期望數組相同
        Assertions.assertArrayEquals(expectedIntArr, actualIntArr, "actualArray not Equals expectedArray.");
    }

    @Test
    public void assertIterableEqualsCase() {
//        public static void assertIterableEquals(Iterable<?> expected, Iterable> actual)
//        public static void assertIterableEquals(Iterable<?> expected, Iterable> actual, String message)
//        public static void assertIterableEquals(Iterable<?> expected, Iterable> actual, Supplier<String> messageSupplier)

//        斷言可跌代項與預期可跌代項完全相等(包括數量與順序)
        Assertions.assertIterableEquals(expectedStrList, actualStrList, "actualStrList's Iterable not equals expectedStrList's Iterable.");

    }

    @Test
    public void assertLinesMatchCase() {
//        斷言預期的String　list與實際String list是否匹配。
//        1.檢查是否expected.equals(actual)如果是，則繼續下一對
//        2.否則將expected作為正則表達式來檢查看看，如果應用正則表達式後相等，則繼續下一對
//        3.否則，檢查expected行是否為fast-forward，如果適用相應地fast-forward實際行並轉到1。
        Assertions.assertLinesMatch(expectedStrList, actualStrList, "fail");
    }

    @Test
    public void assertAllCase() {
        int num1 = 2;
        int num2 = 2;
        int expected1 = 4;
        int expected2 = 3;

        int actual = AssertionCalculator.add(num1, num2);

        //多重斷言，無論所有斷言有無出錯都會跑完，最後再給報告資料
        Assertions.assertAll(
                () -> Assertions.assertTrue(expected1 == actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") == " + expected1 + "is false"),
                () -> Assertions.assertTrue(expected2 == actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") == " + expected2 + "is false"),
                () -> Assertions.assertFalse(expected1 == actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") == " + expected1 + "is true"),
                () -> Assertions.assertFalse(expected2 == actual, "AssertionCalculator.add(" + num1 + "," + num2 + ") == " + expected2 + "is true")
        );
    }

    @Test
    public void failCase() {
        //fail就是直接讓測試失敗
//        public static void fail(String message)
//        public static void fail(Throwable cause)
//        public static void fail(String message, Throwable cause)
//        public static void fail(Supplier<String> messageSupplier)

        Assertions.fail("test failed");
    }
}
