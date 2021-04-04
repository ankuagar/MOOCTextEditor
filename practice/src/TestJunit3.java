import static org.junit.Assert.assertEquals;
import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import junit.framework.Test;

public class TestJunit3 extends TestResult {
    // add the error
    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test) test, t);
        System.out.println("Add error");
    }
//
//    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((junit.framework.Test) test, t);
        System.out.println("Add failure");
    }

    @org.junit.Test
    public void testAdd() {
        assertEquals(6, 6);
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        //stop the test here
        System.out.println("going away");
    }
}