import com.javafxMvc.model.MvcMap;
import com.javafxMvc.reflection.mvc.ModelReflectionLoader;
import com.javafxMvc.test.TestModel;
import org.reflections.Reflections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModelReflectionLoaderTest {

    private MvcMap mvcMap;

    @Before
    public void setUp(){
        mvcMap = new MvcMap();
    }

    @Test
    public void load_normal_modelIsAddedToMvcMap(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ModelReflectionLoader.load(reflections, mvcMap);

        //assert
        assertEquals(1,mvcMap.getModelClasses().size());
    }

    @Test
    public void load_normal_mvcMapContainsClass(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ModelReflectionLoader.load(reflections, mvcMap);

        //assert
        assertEquals(TestModel.class, mvcMap.getModelClasses().get(0));
    }

    @Test
    public void load_normal_instanceIsOfCorrectClass(){
        //arrange
        Reflections reflections = new Reflections("com.javafxMvc.test");

        //act
        ModelReflectionLoader.load(reflections, mvcMap);

        //assert
        assertTrue(mvcMap.getMvcObjectByClass(TestModel.class) instanceof TestModel);
    }
}

