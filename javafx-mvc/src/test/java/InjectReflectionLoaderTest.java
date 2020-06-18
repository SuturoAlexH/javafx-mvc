import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.mvc.ControllerReflectionLoader;
import com.javafxMvc.reflection.mvc.InjectReflectionLoader;
import com.javafxMvc.reflection.mvc.ModelReflectionLoader;
import com.javafxMvc.reflection.mvc.ViewReflectionLoader;
import com.javafxMvc.test.TestController;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertNotNull;

public class InjectReflectionLoaderTest {

    private static final String TEST_PACKAGE = "com.javafxMvc.test";

    private MvcMap mvcMap;

    private ResourceBundle resourceBundle;

    @Before
    public void setUp(){
        mvcMap = new MvcMap();

        resourceBundle = ResourceBundle.getBundle("language", Locale.GERMANY);
    }

    @Test
    public void load_normal_fieldIsNotNull(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ModelReflectionLoader.load(reflections, mvcMap);
        ControllerReflectionLoader.load(reflections, mvcMap);
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);
        InjectReflectionLoader.load(mvcMap);

        //assert
        TestController controller = (TestController) mvcMap.getMvcObjectByClass(TestController.class);
        assertNotNull(controller.getModel());
    }
}
