import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

//@Disabled //如果使用@Disabled的話，這一類別都不會顯示於測試中。
public class TestAnnotationsTest {
    @Disabled
    @Test
    void DisabledCase()
    {
        System.out.println("You should not see the test");
    }

    //	RepeatedTest(重複次數)
    @RepeatedTest(5)
    public void repeatedTestCase1() {
        System.out.println("Repeated Test Case1.");
    }

    /*	RepeatedTest(value=重複次數, name="自定義顯示名稱")
     *  {displayName}:設定顯示的名稱, {totalRepetitions}:重複的總數, {currentRepetition}:當前重複的計數
     */
    @DisplayName("Repeated Test Case2")
    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
    public void repeatedTestCase2() {
        System.out.println("Repeated Test Case2.");
    }


    /*	當輸入@ParameterizedTest時可以用name自訂測試名稱EX:@ParameterizedTest(name="執行序號 [{index}], String參數 [{0}],int參數 [{1}]")，
     *   之後必須使用以下的數據源註解來導入參數:
     *	@NullSource可以調用null當一次輸入參數。
     *  @EmptySource可以調用空字串當一次輸入參數。(限定當參數為String時)
     *	@NullAndEmptySource可以同時調用null跟空字串當來輸入參數。(限定當參數為String時)
     *	@ValueSource可以直接輸入單一類別參數。EX:strings:String, shorts:short, bytes:byte, ints:int, longs:long, floats:float, doubles:double, chars:char, booleans:boolean, classeses:classes
     *	@MethodSource來指定一個方法名後用該方法的回傳來輸入參數，該回傳必須為Steam類型。
     *	@EnumSource來指定Enum當輸入參數，必須在方法的輸入參數類型中知道要調用哪個enum。EX:enum名稱為Types則在測試方法中為public void ParameterizedTest(Types type)
     *  @CsvSource使用Csv來當輸入參數。EX:@CsvSource({"apple1, 11", "banana1, 12","'lemon1, lime1', 0x0A"})
     *	@CsvFileSource調用外部csv文件來當輸入參數，並且可以用numLinesToSkip指定跳過的行數。EX:@CsvFileSource(files = "src/test/resources/two-column.csv", numLinesToSkip = 1)
     *	@ArgumentsSource自定義參數來源 @ArgumentsSource(MyArgumentsProvider.class)。
     */
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "a", "b", "c" } )
    public void ParameterizedTest(String testString) {
        System.out.printf("Parameterized Test Basic Case. string : %s" ,testString);
        System.out.println();
    }
}