package es.iespto.agl.room_1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Alumno.TABLE_NAME)
public class Alumno {
    public static final String TABLE_NAME = "alumnos";
    public static final String ID = "dni";
    public static final String NOMBRE = "nombre";
    public static final String EDAD = "edad";
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    @NonNull
    private String dni;
    @ColumnInfo(name = NOMBRE)
    private String nombre;
    @ColumnInfo(name = EDAD)
    private int edad;

    public Alumno(){}
    public Alumno(String dni, String nombre, int edad){
        this.dni=dni;
        this.edad=edad;
        this.nombre=nombre;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
