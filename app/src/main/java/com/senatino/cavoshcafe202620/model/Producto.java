package com.senatino.cavoshcafe202620.model;

public class Producto {

    private final int id;
    private final String nombre;
    private final double precio;
    private final String detalle;
    private final int imagenResId;
    private final String imagenUrl;

    public Producto(int id, String nombre, double precio, String detalle, int imagenResId, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle = detalle;
        this.imagenResId = imagenResId;
        this.imagenUrl = imagenUrl;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
}