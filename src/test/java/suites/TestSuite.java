package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleTest.class,
        ChangeAppConditionTest.class,
        GetStartedTest.class,
        LIstTest.class,
        SearchTest.class
})
public class TestSuite {
}
