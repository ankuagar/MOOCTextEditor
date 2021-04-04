import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
public class TestJunit {

    private String message = "Hello World";
    private MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        assertEquals(this.message, this.messageUtil.printMessage());
    }

    @Test
    public void testAdd() {
        //test data
        int num = 5;
        String temp = "null";
        String str = "Junit is working fine";

        //check for equality
        assertEquals("Junit is working fine", str);

        //check for false condition
        assertFalse( "Number was > 6", num > 6);

        //check for not null value
        assertNotNull("temp is null", temp);
    }
}