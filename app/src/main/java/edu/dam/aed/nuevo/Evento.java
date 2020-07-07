package edu.dam.aed.nuevo;

public class Evento {
    private String numeroIdentificador;
    private String nombreEquipo1;
    private String nombreEquipo2;
    private String cuota1;
    private String cuotax;
    private String Cuota2;
    private String hora;
    private String fecha;
    private String liga;
    private String casaApuestas;

    public Evento(String numeroIdentificador, String nombreEquipo1, String nombreEquipo2, String cuota1, String cuotax, String cuota2, String hora, String fecha, String liga, String casaApuestas) {
        this.numeroIdentificador = numeroIdentificador;
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.cuota1 = cuota1;
        this.cuotax = cuotax;
        Cuota2 = cuota2;
        this.hora = hora;
        this.fecha = fecha;
        this.liga = liga;
        this.casaApuestas = casaApuestas;
    }

    public Evento(String numeroIdentificador, String nombreEquipo1, String nombreEquipo2, String cuota1, String cuotax, String cuota2, String liga, String casaApuestas) {
        this.numeroIdentificador = numeroIdentificador;
        this.nombreEquipo1 = nombreEquipo1;
        this.nombreEquipo2 = nombreEquipo2;
        this.cuota1 = cuota1;
        this.cuotax = cuotax;
        Cuota2 = cuota2;
        this.liga = liga;
        this.casaApuestas = casaApuestas;
    }

    public String getNombreEquipo1() {
        return this.nombreEquipo1;
    }

    public void setNombreEquipo1(String nombreEquipo1) {
        this.nombreEquipo1 = nombreEquipo1;
    }

    public String getNombreEquipo2() {
        return this.nombreEquipo2;
    }

    public void setNombreEquipo2(String nombreEquipo2) {
        this.nombreEquipo2 = nombreEquipo2;
    }

    public String getCuota1() {
        return this.cuota1;
    }

    public void setCuota1(String cuota1) {
        this.cuota1 = cuota1;
    }

    public String getCuotax() {
        return this.cuotax;
    }

    public void setCuotax(String cuotax) {
        this.cuotax = cuotax;
    }

    public String getCuota2() {
        return this.Cuota2;
    }

    public void setCuota2(String cuota2) {
        this.Cuota2 = cuota2;
    }

    public String getHora() {return hora; }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getCasaApuestas() {
        return casaApuestas;
    }

    public void setCasaApuestas(String casaApuestas) {
        this.casaApuestas = casaApuestas;
    }
}

