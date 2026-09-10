package com.senatino.cavoshcafe202620.model;

public class Categoria {

    private final int id;
    private final String nombre;
    private final int iconoResId;

    public Categoria(int id, String nombre, int iconoResId) {
        this.id = id;
        this.nombre = nombre;
        this.iconoResId = iconoResId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIconoResId() {
        return iconoResId;
    }
}