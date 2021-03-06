# l10n
This class is used to lookup the translated words of the current language.
It is necessary put some property files in the resource folder of your app with the following naming:

 - language_de.properties
 - language_en.properties
 - language_fr.properties
 
 Note that language is the base name and can be chosen by your own. A property file should look like this:
 ```properties
 key= my value \
 key2=my value 2\
 placeholder=my value is {0}
```
 
 The App must also extend MVCApplication of the core package and implement the loadResourceBundle method. 
 You need to specify the base name(in our case language) and the current language.
```java
    public class App extends MVCApplication{
        
         @Override
         public ResourceBundle loadResourceBundle() {
            return ResourceBundle.getBundle("language", Locale.GERMANY);
         }
    }
```
 
##### exmaple:

```java
    import com.javafxMvc.l10n.L10n;@MVCController
    public class Controller{
    
        public void doSmth(){
            String myValue = L10n.getInstance().get("key");// my value
            String myValueIs10 = L10n.getInstance().get("placeholder", 10); //my value is 10
        }
    }
```