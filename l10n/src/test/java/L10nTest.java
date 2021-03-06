import com.javafxMvc.l10n.L10n;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class L10nTest {

    @Before
    public void setUp(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("language", Locale.GERMANY);
        L10n.load(resourceBundle);
    }

    @Test
    public void get_zeroParameters_correctValue(){
        //arrange

        //act
        String value = L10n.getInstance().get("test_0");

        //assert
        assertEquals("value", value);
    }

    @Test
    public void get_oneParameter_correctValue(){
        //arrange

        //act
        String value = L10n.getInstance().get("test_1", "a");

        //assert
        assertEquals("value a", value);
    }

    @Test
    public void get_twoParameter_correctValue(){
        //arrange

        //act
        String value = L10n.getInstance().get("test_2", "a", "b");

        //assert
        assertEquals("value a b", value);
    }
}
