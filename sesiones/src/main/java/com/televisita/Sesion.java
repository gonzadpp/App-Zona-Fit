package com.televisita;

public class Sesion {

    private String idSesion;
    private String fechaSesion;
    private String horaSesion;
    private String duracionSesion;
    private String terminalVisita;
    private String terminalPPL;
    private String estatusSesion;

    public Sesion(String idSesion, String fechaSesion, String horaSesion, String duracionSesion, String terminalVisita,
            String terminalPPL, String estatusSesion) {
        this.idSesion = idSesion;
        this.fechaSesion = fechaSesion;
        this.horaSesion = horaSesion;
        this.duracionSesion = duracionSesion;
        this.terminalVisita = terminalVisita;
        this.terminalPPL = terminalPPL;
        this.estatusSesion = estatusSesion;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(String fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public String getHoraSesion() {
        return horaSesion;
    }

    public void setHoraSesion(String horaSesion) {
        this.horaSesion = horaSesion;
    }

    public String getDuracionSesion() {
        return duracionSesion;
    }

    public void setDuracionSesion(String duracionSesion) {
        this.duracionSesion = duracionSesion;
    }

    public String getTerminalVisita() {
        return terminalVisita;
    }

    public void setTerminalVisita(String terminalVisita) {
        this.terminalVisita = terminalVisita;
    }

    public String getTerminalPPL() {
        return terminalPPL;
    }

    public void setTerminalPPL(String terminalPPL) {
        this.terminalPPL = terminalPPL;
    }

    public String getEstatusSesion() {
        return estatusSesion;
    }

    public void setEstatusSesion(String estatusSesion) {
        this.estatusSesion = estatusSesion;
    }

    @Override
    public String toString() {
        return "Sesion [ " + idSesion + " " + fechaSesion + " " + horaSesion
                + " " + duracionSesion + "  " + terminalVisita + "  "
                + terminalPPL + "   " + estatusSesion + " ]";
    }

}
