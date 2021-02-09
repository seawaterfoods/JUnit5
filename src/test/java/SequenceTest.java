import org.junit.jupiter.api.*;

public class SequenceTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Sequence test beforeAll.");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("-------------------------");
        System.out.println("Sequence test beforeEach.");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Sequence test afterEach.");
        System.out.println("------------------------");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Sequence test afterAll.");
    }

    @Test
    public void case1(){
        System.out.println("Case1.");
    }

    @Test
    public void case2(){
        System.out.println("Case2.");
    }
}
