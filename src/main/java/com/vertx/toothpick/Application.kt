package com.vertx.toothpick

import io.vertx.reactivex.core.Vertx
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

object Embedded {
    @JvmStatic
    fun main(args: Array<String>) {
        initToothpick()
        Vertx.vertx().deployVerticle("com.vertx.toothpick.MainVerticle")
    }

    private fun initToothpick() {
        Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
        FactoryRegistryLocator.setRootRegistry(FactoryRegistry())
        MemberInjectorRegistryLocator.setRootRegistry(MemberInjectorRegistry())

        val appScope = Toothpick.openScope(Scopes.APP_SCOPE)
        appScope.installModules(AppModule("App-dsadasdklajsdlkajsdklajskldjaklsdjaklsjd"))
    }
}