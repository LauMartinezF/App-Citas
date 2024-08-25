package com.example.proyecto.citas.acitas;

import java.util.Objects;

public class Cita {

    private final String nombres;
    private final String apellidos;
    private final String tipoDocumento;
    private final String numeroDocumento;
    private final String celular;
    private final String email;
    private final String tipoCita;
    private final String especialista;
    private final String fecha;
    private final String hora;

    public Cita(String nombres, String apellidos, String tipoDocumento, String numeroDocumento, String celular, String email, String tipoCita, String especialista, String fecha, String hora) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.celular = celular;
        this.email = email;
        this.tipoCita = tipoCita;
        this.especialista = especialista;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public String getEspecialista() {
        return especialista;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }


}
