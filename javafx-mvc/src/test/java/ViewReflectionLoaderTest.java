import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.mvc.ViewReflectionLoader;
import com.javafxMvc.test.TestView;
import org.reflections.Reflections;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class ViewReflectionLoaderTest {

    private static final String TEST_PACKAGE = "com.javafxMvc.test";

    private MvcMap mvcMap;

    private ResourceBundle resourceBundle;

    @Before
    public void setUp(){
        mvcMap = new MvcMap();

        resourceBundle = ResourceBundle.getBundle("language", Locale.GERMANY);
    }

    @Test
    public void load_normal_viewIsAddedToMvcMap(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);

        //assert
        assertEquals(1, mvcMap.getMvcClasses().size());
    }

    @Test
    public void load_normal_mvcMapContainsClass(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);

        //assert
        assertEquals(TestView.class, mvcMap.getMvcClasses().get(0));
    }

    @Test
    public void load_normal_instanceIsOfCorrectClass(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);

        //assert
        assertTrue(mvcMap.getMvcObjectByClass(TestView.class) instanceof TestView);
    }

    @Test
    public void load_normal_parentIsAddedToMvcMap(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ViewReflectionLoader.load(reflections, mvcMap, resourceBundle);

        //assert
        assertNotNull(mvcMap.getNodeByClass(TestView.class));
    }
}


