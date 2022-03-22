package com.sofka.reactividad.ejerciciouno.model;

import java.util.Objects;

public class Correo {

    private String correo;
    private boolean correoEnviado;

    public Correo(String correo) {
        this.correo = correo;
        this.correoEnviado = false;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isCorreoEnviado() {
        return correoEnviado;
    }

    public void setCorreoEnviado(boolean correoEnviado) {
        this.correoEnviado = correoEnviado;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Correo{" +
                "correo='" + correo + '\'' +
                ", correoEnviado=" + correoEnviado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Correo)) return false;
        Correo correo1 = (Correo) o;
        return isCorreoEnviado() == correo1.isCorreoEnviado() && getCorreo().equals(correo1.getCorreo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCorreo(), isCorreoEnviado());
    }
}
