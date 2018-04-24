package com.vertx.toothpick;

import toothpick.config.Module;

public class AppModule extends Module {
    public AppModule(String str) {
        bind(StrBox.class).toInstance(new StrBox(str));
        bind(ToProvide.class).toProvider(ToProvideProvider.class);
    }
}
