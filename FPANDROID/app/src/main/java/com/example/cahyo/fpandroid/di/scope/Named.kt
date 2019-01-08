package com.example.cahyo.fpandroid.di.scope

import java.lang.annotation.Documented
import javax.inject.Qualifier

@Qualifier
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(val value: String)