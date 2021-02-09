import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {
    //    當OS為WINDOWS或MAC時，測試方法才會執行。
    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    public void OSEqualsTest() {
        System.out.println(System.getProperty("os.name"));
    }

    //    當OS為MAC時，測試方法不執行。
    @Test
    @DisabledOnOs(OS.MAC)
    public void OSNotEqualsTest() {
        Assertions.assertNotEquals(OS.MAC, System.getProperty("os.name"), "OS is MAC!");
    }

    //    當JRE版本為8 or 9，測試方法才會執行。
    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
    public void JreEqualsTest() {
        System.out.println(System.getProperty("java.version"));
    }

    //  當JRE版本為9，測試方法不執行。
    @Test
    @DisabledOnJre(JRE.JAVA_9)
    public void JreNotEqualsTest() {
        Assertions.assertNotEquals(JRE.JAVA_9, System.getProperty("java.version"), "JRE is 9!");
    }

    //　當前JRE版本為8~9的範圍時，測試方法才會執行。
    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_9)
    public void JreRangeEqualsTest() {
        System.out.println("JRE : " + System.getProperty("java.version"));
    }

    //  當前JRE版本為9~11的範圍中時，測試方法不執行。
    @Test
    @DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    public void JreRangeNotEqualsTest() {
        System.out.println("JRE : " + System.getProperty("java.version"));
    }

    //    指定系統屬性:os.arch的期望值(可模糊搜尋)為".*64.*"，測試方法才可以執行。
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    public void systemPropertyTest() {
        System.out.println("OS arch : " + System.getProperty("os.arch"));
    }

    //     指定系統屬性:java.vm.name的期望值(可模糊搜尋)為".*HotSpot.*"，測試方法不會執行。
    @Test
    @DisabledIfSystemProperty(named = "java.vm.name", matches = ".*HotSpot.*")
    public void systemPropertyNotEqualsTest() {
        System.out.println("java.vm.name : " + System.getProperty("java.vm.name"));
    }

    //    當環境變數:JAVA_HOME的期望值(可模糊搜尋)為 ".*"(非NULL)，測試方法才可以執行。
    @Test
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*")
    public void ifEnvironmentVariableHaveJAVA_HOMETest() {
        System.out.println("JAVA_HOME : " + System.getenv("USERNAME"));
    }

    //    當環境變數:GOPATH的期望值(可模糊搜尋)為 ".*"(非NULL)，測試方法不會執行。
    @Test
    @DisabledIfEnvironmentVariable(named = "GOPATH", matches = ".*")
    public void ifEnvironmentVariableHaveNotGOPATHTest() {
        System.out.println("GOPATH : " + System.getenv("GOPATH"));
    }

    //    指定trueCustomCondition的static方法，當該方法回傳true時，測試方法才可以執行。
    @Test
    @EnabledIf("trueCustomCondition")
    public void staticTrueMethodTest() {
        System.out.println("trueCustomCondition : " + trueCustomCondition());
    }

    public static boolean trueCustomCondition() {
        return true;
    }

    //    指定falseCustomCondition的static方法，當該方法回傳false時，測試方法才可以執行。
    @Test
    @DisabledIf("falseCustomCondition")
    public void staticFalseMethodTest() {
        System.out.println("falseCustomCondition : " + falseCustomCondition());
    }

    public static boolean falseCustomCondition() {
        return false;
    }
}

