package es.iespto.agl.room_1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class AlumnoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract Long insert(Alumno alumno);


    @Query("SELECT * FROM " + Alumno.TABLE_NAME)
    public abstract List<Alumno> getAll();

}
