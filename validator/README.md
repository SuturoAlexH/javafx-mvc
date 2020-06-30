# validation
Some basic validator are implemented right now. If you want to implement a custom validator, then just extend the AbstractValidator

    1. Not empty validator
    2. Integer validator
    3. Double validator
    
#####exmaple:

```java
    @MVCController
    public class Controller{
    
        @Validator(Model.class)
        private CombinedValidator validator;
    }
    
    @MVCModel
    public class Model{
    
        @ValidationProperty(NotEmptyValidator.class)
        private ValidatableProperty<String> value;
    }
```