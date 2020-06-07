import com.javafxMvc.model.ValidatableProperty;
import com.javafxMvc.validator.CombinedValidator;
import com.javafxMvc.validator.NotEmptyValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CombinedValidatorTest {

    private CombinedValidator classUnderTest;

    private NotEmptyValidator validator1;

    private ValidatableProperty<String> validatableProperty1;

    private NotEmptyValidator validator2;

    private ValidatableProperty<String> validatableProperty2;

    private static final String ERROR_TEXT ="errorText";


    @Before
    public void setUp(){
        validatableProperty1 = new ValidatableProperty<>();
        validator1 = new NotEmptyValidator<>(validatableProperty1, ERROR_TEXT);

        validatableProperty2 = new ValidatableProperty<>();
        validator2 = new NotEmptyValidator<>(validatableProperty2, ERROR_TEXT);

        classUnderTest = new CombinedValidator();
        classUnderTest.addValidator(validator1);
        classUnderTest.addValidator(validator2);
    }

    @Test
    public void validate_valid_true(){
        //arrange
        validatableProperty1.valueProperty().set("value");
        validatableProperty2.valueProperty().set("value");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertTrue(valid);
    }

    @Test
    public void validate_oneInvalid_false(){
        //arrange
        validatableProperty1.valueProperty().set("");
        validatableProperty2.valueProperty().set("value");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertFalse(valid);
    }

    @Test
    public void validate_allInvalid_false(){
        //arrange
        validatableProperty1.valueProperty().set("");
        validatableProperty2.valueProperty().set("");

        //act
        boolean valid = classUnderTest.validate();

        //assert
        assertFalse(valid);
    }
}
