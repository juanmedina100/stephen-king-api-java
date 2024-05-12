package com.jimd.stephenkingapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("Year") Integer anio,
        @JsonAlias("Title") String titulo,
        @JsonAlias("Publisher") String publicado,
        @JsonAlias("Pages") Integer pagin,
        @JsonAlias("Notes") List<String> notas
) {

}
