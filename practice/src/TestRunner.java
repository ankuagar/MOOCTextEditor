import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
//Works1
//        public static void main(String[] args) {
//            JUnitCore.main(TestJunit.class.getName());
//        }

// Works2
//    @Test
//    public void mymethod() {
          // See: https://github.com/junit-team/junit4/blob/main/src/main/java/org/junit/runner/JUnitCore.java#L35
//        JUnitCore.main(TestJunit.class.getName());
//    }

    //Works3
        public static void main(String[] args) {
            // https://github.com/junit-team/junit4/blob/main/src/main/java/org/junit/runner/JUnitCore.java#L48
            Result result = JUnitCore.runClasses(TestJunit.class, TestJunit2.class, TestJunit3.class);
            for(Failure f: result.getFailures()) {
                System.out.println(f);
            }
            System.out.println(result.wasSuccessful());
        }
}