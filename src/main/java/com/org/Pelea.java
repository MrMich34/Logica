package com.org;

import java.util.List;

public class Pelea {
    Pokemon pokemon1;
    Pokemon pokemon2;

    public Pelea(){
        pokemon1 = new Pokemon();
        pokemon2 = new Pokemon();

    }

    public Pelea(Pelea p){
        pokemon1 = p.pokemon1;
        pokemon2 = p.pokemon2;
    }

    public void anadirNombre1(String nombrePokemon){

        pokemon1.setNombre(nombrePokemon);

    }

    public void anadirNombre2(String nombrePokemon){

        pokemon2.setNombre(nombrePokemon);
    }

    public void anadirImagen1(String imagen){
        pokemon1.setImagen(imagen);
    }

    public void anadirImagen2(String imagen){
        pokemon2.setImagen(imagen);
    }

    public void anadirEstadisticas1(List<Integer> list){
        pokemon1.anadirEstadisticas(list.get(0), list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
    }

    public void anadirEstadisticas2(List<Integer> list){
        pokemon2.anadirEstadisticas(list.get(0), list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
    }

    public void anadirMovimientos1(List<List<String>> lm){
        for(List<String> l : lm){
            pokemon1.anadirMovimiento(l);
        }
    }

    public void anadirMovimientos2(List<List<String>> lm){
        for(List<String> l : lm){
            pokemon2.anadirMovimiento(l);
        }
    }

    public Pokemon getPokemon1(){
        System.out.println(pokemon1);
        return pokemon1;
    }
    public Pokemon getPokemon2(){
        System.out.println(pokemon2);
        return pokemon2;
    }

    @Override
    public String toString() {
        return "Pelea{" +
                "pokemon1=" + pokemon1 +
                ", pokemon2=" + pokemon2 +
                '}';
    }
}
