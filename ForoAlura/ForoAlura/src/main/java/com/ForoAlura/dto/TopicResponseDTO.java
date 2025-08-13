package com.ForoAlura.dto; // Asegúrate de que coincida con la carpeta real

public class TopicResponseDTO {
    private Long id;
    private String titulo;
    private String contenido;

    public TopicResponseDTO(Long id, String title, String message, String author, String course) {
    }

    public TopicResponseDTO(Long id, String titulo, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
