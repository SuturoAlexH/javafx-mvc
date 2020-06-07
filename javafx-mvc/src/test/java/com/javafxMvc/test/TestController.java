package com.javafxMvc.test;

import com.javafxMvc.annotations.Inject;
import com.javafxMvc.annotations.MVCController;

@MVCController
public class TestController {

    @Inject
    private TestModel model;

    public TestModel getModel(){
        return model;
    }
}
