package es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlumnoDTO {
    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("fechanacimiento")
    @Expose
    private Long fechanacimiento;
    @SerializedName("foto")
    @Expose
    private Object foto;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("estudios")
    @Expose
    private String estudios;
    @SerializedName("matriculas")
    @Expose
    private List<Object> matriculas;

    public AlumnoDTO(){}

    @Override
    public String toString() {
        return "Alumno: " + nombre +
                " Estudios: " + estudios +
                " Fecha Nac: " + fechanacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Long fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Object getFoto() {
        return foto;
    }

    public void setFoto(Object foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public List<Object> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Object> matriculas) {
        this.matriculas = matriculas;
    }

}