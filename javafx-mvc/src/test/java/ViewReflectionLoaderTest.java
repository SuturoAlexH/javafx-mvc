import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.mvc.ViewReflectionLoader;
import com.javafxMvc.test.TestView;
import org.reflections.Reflections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewReflectionLoaderTest {

    private MvcMap mvcMap;

    @Before
    public void setUp(){
        mvcMap = new MvcMap();
    }

    @Test
    public void load_normal_viewIsAddedToMvcMap(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ViewReflectionLoader.load(reflections, mvcMap);

        //assert
        assertEquals(1, mvcMap.getMvcClasses().size());
    }

    @Test
    public void load_normal_mvcMapContainsClass(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ViewReflectionLoader.load(reflections, mvcMap);

        //assert
        assertEquals(TestView.class, mvcMap.getMvcClasses().get(0));
    }

    @Test
    public void load_normal_instanceIsOfCorrectClass(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ViewReflectionLoader.load(reflections, mvcMap);

        //assert
        assertTrue(mvcMap.getMvcObjectByClass(TestView.class) instanceof TestView);
    }

    @Test
    public void load_normal_parentIsAddedToMvcMap(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ViewReflectionLoader.load(reflections, mvcMap);

        //assert
        assertNotNull(mvcMap.getNodeByClass(TestView.class));
    }
}


