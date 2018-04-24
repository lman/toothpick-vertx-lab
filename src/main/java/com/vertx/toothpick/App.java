package com.vertx.toothpick;

import io.vertx.reactivex.core.Vertx;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;

public class App {

    public static void main(String[] args) {
        initToothpick();
        Vertx.vertx().deployVerticle("com.vertx.toothpick.MainVerticle");
    }

    private static void initToothpick() {
        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        FactoryRegistryLocator.setRootRegistry(new FactoryRegistry());
        MemberInjectorRegistryLocator.setRootRegistry(new MemberInjectorRegistry());

        Scope appScope = Toothpick.openScope(Scopes.APP_SCOPE);
        appScope.installModules(new AppModule("App-dsadasdklajsdlkajsdklajskldjaklsdjaklsjd"));
    }
}
