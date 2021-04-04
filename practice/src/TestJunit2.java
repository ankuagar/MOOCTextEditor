import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestJunit2 extends TestCase  {
    protected double fValue1;
    protected double fValue2;

    @Before
    public void setUp() {
        fValue1 = 2.0;
        fValue2 = 3.0;
    }

    @Test
    public void testAdd() {
        //count the number of test cases
        System.out.println("From " + this.getClass().getName() + ": Number of Test Cases = "+ this.countTestCases());

        //test getName
        String name = this.getName();
        System.out.println("From " + this.getClass().getName() + ": " + "Test Case Name = "+ name);

        //test setName
        this.setName("testNewAdd");
        String newName = this.getName();
        System.out.println("From " + this.getClass().getName() + ": " + "Updated Test Case Name = "+ newName);
    }

    //tearDown used to close the connection or clean up activities
    public void tearDown(  ) {
    }
}