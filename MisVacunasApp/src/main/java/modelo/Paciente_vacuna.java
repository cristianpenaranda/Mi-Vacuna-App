/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Paciente_vacuna {
    private String paciente;
    private String vacuna;
    private String enfermero;
    private String fecha;

    //CONSTRUCTOR VACIO DE LA CLASE
    public Paciente_vacuna() {}

    //CONSTRUCTOR DE LA CLASE
    public Paciente_vacuna(String paciente, String vacuna, String enfermero, String fecha) {
        this.paciente = paciente;
        this.vacuna = vacuna;
        this.enfermero = enfermero;
        this.fecha = fecha;
    }

    //METODOS GET Y SET DE LA CLASE
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(String enfermero) {
        this.enfermero = enfermero;
    }
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
