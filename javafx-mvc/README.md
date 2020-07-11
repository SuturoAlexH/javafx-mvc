# javafx-mvc
The core package that provides the mvc pattern framework

##### exmaple:

```java
    import com.javafxMvc.annotations.Inject;
    import com.javafxMvc.annotations.MVCView;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;

    @MVCView("/fxml/view.fxml")
    public class View{
    
        @FXML
        Button myButton;
        
        @FXML
        Label myLabel;
        
        @Inject
        private Controller controller;
    
        public void click(){
            controller.click();
        }       
    }
```

```java
    import com.javafxMvc.annotations.Inject;
    import com.javafxMvc.annotations.MVCController;

    @MVCController
    public class Controller{

        @Inject
        private View view;

        @Inject
        private Model com.schlussdorf.model;
        
        @Bind
        public void bindModelAndView(){
            view.myLabel.textProperty().bindBidirection(com.schlussdorf.model.value);
        }       
        
        public void click(){
            int currentValue = Integer.parseInt(com.schlussdorf.model.currentValue.get());
            com.schlussdorf.model.currentValue.set(currentValue+1);
        } 

    }
```

```java
    import com.javafxMvc.annotations.MVCModel;
    import javafx.beans.property.SimpleStringProperty;
    import javafx.beans.property.StringProperty;

    @MVCModel
    public class Model{
    
        StringProperty value = new SimpleStringProperty("0");
    }
```