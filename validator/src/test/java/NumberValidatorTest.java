import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.validator.NumberValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberValidatorTest {

    private NumberValidator classUnderTest;

    private ValidatableProperty<String> validatableProperty;

    @Before
    public void setUp(){
        validatableProperty = new ValidatableProperty<>();
        classUnderTest = new NumberValidator(validatableProperty);
    }

    @Test
    public void evaluate_validNumber_true(){
        //arrange
        validatableProperty.valueProperty().set("5");

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void evaluate_validEmpty_true(){
        //arrange
        validatableProperty.valueProperty().set("");

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void evaluate_validNull_true(){
        //arrange
        validatableProperty.valueProperty().set(null);

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void evaluate_invalidLetters_false(){
        //arrange
        validatableProperty.valueProperty().set("1a");

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void evaluate_invalidFloatingPointsNumber_false(){
        //arrange
        validatableProperty.valueProperty().set("1.5");

        //act
        boolean valid = classUnderTest.evaluate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void validate_valid_true(){
        //arrange
        validatableProperty.valueProperty().set("5");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void validate_valid_errorTextIsInvisible(){
        //arrange
        validatableProperty.valueProperty().set("5");

        //act
        classUnderTest.validate();

        //assert
        assertFalse(validatableProperty.isIsVisible());
    }

    @Test
    public void validate_invalid_false(){
        //arrange
        validatableProperty.valueProperty().set("a");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void validate_invalid_errorTextIsVisible(){
        //arrange
        validatableProperty.valueProperty().set("a");

        //act
        classUnderTest.validate();

        //assert
        assertTrue(validatableProperty.isIsVisible());
    }
}