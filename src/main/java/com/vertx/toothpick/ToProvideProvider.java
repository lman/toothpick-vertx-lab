package com.vertx.toothpick;

import javax.inject.Inject;
import javax.inject.Provider;

public class ToProvideProvider implements Provider<ToProvide> {
    @Inject StrBox strBox;

    @Override
    public ToProvide get() {
        return new ToProvide(strBox);
    }
}
