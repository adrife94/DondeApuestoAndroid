package edu.dam.aed.nuevo;

public class EventoListado {
    private String equipo1;
    private String equipo2;
    private Double cuota1;
    private Double cuotaX;
    private Double cuota2;
    private String cuota1string, cuota2string,cuotaxstring;

    public EventoListado(String equipo1, String equipo2, String cuota1string, String cuota2string, String cuotaxstring) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.cuota1string = cuota1string;
        this.cuota2string = cuota2string;
        this.cuotaxstring = cuotaxstring;
    }

    public EventoListado(String equipo1, String equipo2, Double cuota1, Double cuotaX, Double cuota2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.cuota1 = cuota1;
        this.cuotaX = cuotaX;
        this.cuota2 = cuota2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public Double getCuota1() {
        return cuota1;
    }

    public void setCuota1(Double cuota1) {
        this.cuota1 = cuota1;
    }

    public Double getCuotaX() {
        return cuotaX;
    }

    public void setCuotaX(Double cuotaX) {
        this.cuotaX = cuotaX;
    }

    public Double getCuota2() {
        return cuota2;
    }

    public void setCuota2(Double cuota2) {
        this.cuota2 = cuota2;
    }

    public String getCuota1string() {
        return cuota1string;
    }

    public void setCuota1string(String cuota1string) {
        this.cuota1string = cuota1string;
    }

    public String getCuota2string() {
        return cuota2string;
    }

    public void setCuota2string(String cuota2string) {
        this.cuota2string = cuota2string;
    }

    public String getCuotaxstring() {
        return cuotaxstring;
    }

    public void setCuotaxstring(String cuotaxstring) {
        this.cuotaxstring = cuotaxstring;
    }
}
