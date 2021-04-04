import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitPractice {
    @Test
    public void testSomething() {
        assertEquals(5, JUnitPractice.something());
    }

    public static int something() {
        return 5;
    }
}

