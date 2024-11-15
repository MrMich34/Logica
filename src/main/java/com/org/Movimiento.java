package com.org;

public class Movimiento {
    String nombre;
    int accuracy;
    int power;
    int pp;
    int priority;
    String tipo;

    public Movimiento(String nombre, String accuracy, String power, String pp, String priority, String tipo) {
        this.nombre = nombre;
        this.accuracy = Integer.parseInt(accuracy);
        this.power = Integer.parseInt(power);
        this.pp = Integer.parseInt(pp);
        this.priority = Integer.parseInt(priority);
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "nombre='" + nombre + '\'' +
                ", accuracy=" + accuracy +
                ", power=" + power +
                ", pp=" + pp +
                ", priority=" + priority +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
