package com.jimd.stephenkingapi.principal;

import com.jimd.stephenkingapi.models.Datos;
import com.jimd.stephenkingapi.models.DatosLibros;
import com.jimd.stephenkingapi.service.ConsumoAPI;
import com.jimd.stephenkingapi.service.ConvierteDatos;

import java.util.Comparator;

public class Principal {

    private static final String URL_BASE = "https://stephen-king-api.onrender.com/api/books";

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void mostrarInformacion(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        //System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, Datos.class);
        //Obteniendo datos de pruebas
        datos.libros().stream()
                .limit(5)
                .map(l->l.titulo()+" - "+l.anio()+" - "+l.pagin())
                .forEach(System.out::println);
        System.out.println("****************************************************");
        //Optener el top 10 de libros mas largos
        System.out.println("Top 10 libros con mas páginas :");
        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::pagin).reversed())
                .limit(10)
                .map(l->"Titulo de libro : "+l.titulo()+" - Año de publicación : "+l.anio()+" - total de páginas : "+l.pagin())
                .forEach(System.out::println);

        //Optener el top 10 de libros mas cortos
        System.out.println("****************************************************");
        System.out.println("Top 10 libros con menos páginas :");
        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::pagin))
                .limit(10)
                .map(l->"Titulo de libro : "+l.titulo()+" - Año de publicación : "+l.anio()+" - total de páginas : "+l.pagin())
                .forEach(System.out::println);

        //Optener top 10 de libros mas antiguos en la página web
        System.out.println("****************************************************");
        System.out.println("Top 10 libros más antiguos segun su publicación :");
        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::anio))
                .limit(10)
                .map(l->"Titulo de libro : "+l.titulo()+" - Año de publicación : "+l.anio()+" - total de páginas : "+l.pagin())
                .forEach(System.out::println);
        //Optener top 10 de libros mas recientes en la página web
        System.out.println("****************************************************");
        System.out.println("Top 10 libros más recientes segun su publicación :");
        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::anio).reversed())
                .limit(10)
                .map(l->"Titulo de libro : "+l.titulo()+" - Año de publicación : "+l.anio()+" - total de páginas : "+l.pagin())
                .forEach(System.out::println);
    }
}
