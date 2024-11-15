package com.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class Pokemon {
    String nombre;
    String imagen;
    List<Movimiento> movimientos;
    Estadisticas estadisticas;

    public Pokemon() {

        nombre = null;
        imagen = null;
        movimientos = new ArrayList<>();
        estadisticas = new Estadisticas();

    }

    public void anadirEstadisticas(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed){
        Estadisticas e = new Estadisticas(hp,attack,defense,specialAttack,specialDefense,speed);
        setEstadisticas(e);
    }

    public void anadirMovimiento(List<String> lm){
        Movimiento m = new Movimiento(lm.get(0),lm.get(1),lm.get(2),lm.get(3),lm.get(4), lm.get(5));
        movimientos.add(m);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", movimientos=" + movimientos +
                ", estadisticas=" + estadisticas +
                '}';
    }
}
