package com.senatino.cavoshcafe202620.domain.model;

public class Producto {
    private int id;
    private String Nombre;
    private double Precio;
    private String Detalle;
    private int imagenResId;
    private String imagenUrl;
    private String Descripcion;
    private int Categoria;
    private int Nuevo;
    private boolean favorito;
    public Producto() {
    }
    public Producto(int id, String nombre, double precio, String detalle, int imagenResId, String imagenUrl) {
        this.id = id;
        this.Nombre = nombre;
        this.Precio = precio;
        this.Detalle = detalle;
        this.imagenResId = imagenResId;
        this.imagenUrl = imagenUrl;
    }
    public boolean isFavorito() {
        return favorito;
    }
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getNombre() {
        return Nombre != null ? Nombre : Descripcion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    public int getNuevo() {
        return Nuevo;
    }

    public void setNuevo(int nuevo) {
        Nuevo = nuevo;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public boolean isNuevo() {
        return Nuevo == 1;
    }
}