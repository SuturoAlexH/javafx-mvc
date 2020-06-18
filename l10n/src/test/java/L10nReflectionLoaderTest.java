import com.javafxMvc.reflection.L10nReflectionLoader;
import com.javafxMvc.test.TestClass;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static junit.framework.TestCase.assertNotNull;

public class L10nReflectionLoaderTest {
    private Map<Class, Object> mvcMap;

    private ResourceBundle resourceBundle;

    @Before
    public void setUp(){
        mvcMap = new HashMap<>();
        mvcMap.put(TestClass.class, new TestClass());

        resourceBundle = ResourceBundle.getBundle("language", Locale.GERMANY);
    }

    @Test
    public void load_normal_l10nIsNotNull(){
        //arrange

        //act
        L10nReflectionLoader.load(mvcMap, resourceBundle);

        //assert
        TestClass testClass = (TestClass) mvcMap.get(TestClass.class);
        assertNotNull(testClass.getL10n());
    }
}
