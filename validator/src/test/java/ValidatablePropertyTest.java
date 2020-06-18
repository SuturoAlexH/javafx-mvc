import com.javafxMvc.model.ValidatableProperty;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class ValidatablePropertyTest {

    private ValidatableProperty<String> classUnderTest;

    @Before
    public  void setUp(){
        classUnderTest = new ValidatableProperty();
    }

    @Test
    public void reset_normal_valueIsNull(){
        //arrange
        classUnderTest.valueProperty().set("notNull");

        //act
        classUnderTest.reset();

        //assert
        assertNull(classUnderTest.getValue());
    }

    @Test
    public void reset_normal_visibleIsFalse(){
        //arrange
        classUnderTest.isVisibleProperty().set(true);

        //act
        classUnderTest.reset();

        //assert
        assertFalse(classUnderTest.isIsVisible());
    }
}
