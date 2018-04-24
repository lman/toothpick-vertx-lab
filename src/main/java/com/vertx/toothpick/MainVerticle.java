package com.vertx.toothpick;

import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.reactivex.core.AbstractVerticle;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;

public class MainVerticle extends AbstractVerticle {
    @Inject StrBox box;

    @Override
    public void init(Vertx vertx, Context context) {
        super.init(vertx, context);
        Scope scope = Toothpick.openScope(Scopes.APP_SCOPE);
        Toothpick.inject(this, scope);
    }

    @Override
    public void start() throws Exception {
        super.start();
        System.out.println(box.getBox());
    }
}
