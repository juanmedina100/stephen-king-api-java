package com.jimd.stephenkingapi.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json,Class<T> clase);
}
