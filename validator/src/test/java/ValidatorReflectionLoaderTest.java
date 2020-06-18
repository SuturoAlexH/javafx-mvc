import com.javafxMvc.reflection.ValidatorReflectionLoader;
import com.javafxMvc.test.TestController;
import com.javafxMvc.test.TestModel;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ValidatorReflectionLoaderTest {

    private Map<Class, Object> mvcMap;

    @Before
    public void setUp(){
        mvcMap = new HashMap<>();
        mvcMap.put(TestController.class, new TestController());
        mvcMap.put(TestModel.class, new TestModel());
    }

    @Test
    public void load_normal_combinedValidatorIsNotNull(){
        //arrange

        //act
        ValidatorReflectionLoader.load(mvcMap);

        //assert
        TestController testController = (TestController) mvcMap.get(TestController.class);
        assertNotNull(testController.getCombinedValidator());
    }

    @Test
    public void load_normal_validatablePropertiesAreNotNull(){
        //arrange

        //act
        ValidatorReflectionLoader.load(mvcMap);

        //assert
        TestModel testModel = (TestModel) mvcMap.get(TestModel.class);
        assertNotNull(testModel.getProperty1());
        assertNotNull(testModel.getProperty2());
    }

    @Test
    public void load_normal_validatorsAreAddedToCombinedValidator(){
        //arrange

        //act
        ValidatorReflectionLoader.load(mvcMap);

        //assert
       TestController testController = (TestController) mvcMap.get(TestController.class);
       assertEquals(2, testController.getCombinedValidator().getValidators().size());
    }
}
