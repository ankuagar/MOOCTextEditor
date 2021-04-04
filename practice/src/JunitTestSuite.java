import junit.framework.TestFailure;
import junit.framework.TestSuite;
import junit.framework.TestResult;
import org.junit.runner.notification.Failure;

import java.util.Enumeration;

public class JunitTestSuite {
    public static void main(String[] a) {
        // add the test's in the suite
        TestSuite suite = new TestSuite(TestJunit.class, TestJunit2.class, TestJunit3.class);
        TestResult result = new TestResult();
        suite.run(result);
        Enumeration<TestFailure> errors = result.errors();
        Enumeration<TestFailure> failures = result.failures();

        while(errors.hasMoreElements()) {
            System.out.println(errors.nextElement().toString());
        }

        while(failures.hasMoreElements()) {
            System.out.println(failures.nextElement().toString());
        }

        System.out.println("From " + JunitTestSuite.class.getName() + ": " + result.wasSuccessful());
        System.out.println("From " + JunitTestSuite.class.getName() + ": Failure count :" + result.failureCount());
        System.out.println("From " + JunitTestSuite.class.getName() + ": Error count :" + result.errorCount());
        System.out.println("From " + JunitTestSuite.class.getName() + ": " + "Number of test cases in result = " + result.runCount());
    }
}