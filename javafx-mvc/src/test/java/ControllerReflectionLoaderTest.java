import com.javafxMvc.reflection.mvc.ControllerReflectionLoader;
import com.javafxMvc.model.MvcMap;
import com.javafxMvc.test.TestController;
import org.reflections.Reflections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControllerReflectionLoaderTest {

    private static final String TEST_PACKAGE = "com.javafxMvc.test";

    private MvcMap mvcMap;

    @Before
    public void setUp(){
        mvcMap = new MvcMap();
    }

    @Test
    public void load_normal_controllerIsAddedToMvcMap(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ControllerReflectionLoader.load(reflections, mvcMap);

        //assert
        assertEquals(1,mvcMap.getControllerClasses().size());
    }

    @Test
    public void load_normal_mvcMapContainsClass(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ControllerReflectionLoader.load(reflections, mvcMap);

        //assert
        assertEquals(TestController.class, mvcMap.getControllerClasses().get(0));
    }

    @Test
    public void load_normal_instanceIsOfCorrectClass(){
        //arrange
        Reflections reflections = new Reflections(TEST_PACKAGE);

        //act
        ControllerReflectionLoader.load(reflections, mvcMap);

        //assert
        assertTrue(mvcMap.getMvcObjectByClass(TestController.class) instanceof TestController);
    }
}
