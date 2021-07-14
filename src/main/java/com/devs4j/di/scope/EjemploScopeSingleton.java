package com.devs4j.di.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton") // si no se define un scope por defaul es el singleton
public class EjemploScopeSingleton {

}
