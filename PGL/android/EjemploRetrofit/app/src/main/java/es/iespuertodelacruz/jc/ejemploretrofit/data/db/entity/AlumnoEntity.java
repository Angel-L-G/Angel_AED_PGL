package es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = AlumnoEntity.TABLE_NAME)
public class AlumnoEntity {
    public static final String TABLE_NAME = "alumnos";
    public static final String ID = "dni";
    public static final String NOMBRE = "nombre";
    public static final String ESTUDIOS = "estudios";
    public static final String FECHANAC = "fechanacimiento";

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    @NonNull
    private String dni;
    @ColumnInfo(name = NOMBRE)
    private String nombre;
    @ColumnInfo(name = ESTUDIOS)
    private int estudios;
    @ColumnInfo(name = FECHANAC)
    private int fechanacimiento;

    public AlumnoEntity(){}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstudios() {
        return estudios;
    }

    public void setEstudios(int estudios) {
        this.estudios = estudios;
    }

    public int getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(int fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public String toString() {
        return "AlumnoEntity: " + nombre +
                " Estudios: " + estudios +
                " Fecha Nac: " + fechanacimiento;
    }
}
