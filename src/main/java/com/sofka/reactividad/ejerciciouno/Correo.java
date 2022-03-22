package com.sofka.reactividad.ejerciciouno;

import java.util.Objects;

public class Correo {

    private String correo;

    public Correo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Correo{" +
                "correo='" + correo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Correo)) return false;
        Correo correo1 = (Correo) o;
        return getCorreo().equals(correo1.getCorreo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCorreo());
    }
}
