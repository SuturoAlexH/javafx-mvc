package com.javafxMvc.test;

import com.javafxMvc.annotations.InjectL10n;
import com.javafxMvc.l10n.L10n;

public class TestClass {

    @InjectL10n
    private L10n l10n;

    public L10n getL10n(){
        return l10n;
    }
}
