import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.validator.NotEmptyValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotEmptyValidatorTest {

    private NotEmptyValidator classUnderTest;

    private ValidatableProperty<String> validatableProperty;

    private static final String ERROR_TEXT ="errorText";

    @Before
    public void setUp(){
        validatableProperty = new ValidatableProperty<>();
        classUnderTest = new NotEmptyValidator<>(validatableProperty, ERROR_TEXT);
    }

    @Test
    public void evaluate_valid_true(){
        //arrange
        validatableProperty.valueProperty().set("value");

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void evaluate_invalidEmpty_false(){
        //arrange
        validatableProperty.valueProperty().set("");

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void evaluate_invalidNull_false(){
        //arrange
        validatableProperty.valueProperty().set(null);

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void validate_valid_true(){
        //arrange
        validatableProperty.valueProperty().set("value");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void validate_valid_errorTextIsInvisible(){
        //arrange
        validatableProperty.valueProperty().set("value");

        //act
        classUnderTest.validate();

        //assert
        assertFalse(validatableProperty.isIsVisible());
    }

    @Test
    public void validate_invalid_false(){
        //arrange
        validatableProperty.valueProperty().set("");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void validate_invalid_errorTextIsVisible(){
        //arrange
        validatableProperty.valueProperty().set("");

        //act
        classUnderTest.validate();

        //assert
        assertTrue(validatableProperty.isIsVisible());
    }

    @Test
    public void validate_invalid_errorTextIsSet(){
        //arrange
        validatableProperty.valueProperty().set("");

        //act
        classUnderTest.validate();

        //assert
        assertEquals(ERROR_TEXT, validatableProperty.getError());
    }
}