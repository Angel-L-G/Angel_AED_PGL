package es.iespuertodelacruz.jc.ejemploretrofit.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity.AlumnoEntity;

public abstract class AlumnoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract Long insert(AlumnoEntity alumnoEntity);

    @Delete
    public abstract void delete(AlumnoEntity alumnoEntity);

    @Query("SELECT * FROM "+ AlumnoEntity.TABLE_NAME +" WHERE "+AlumnoEntity.NOMBRE +" LIKE :nombre")
    public abstract List<AlumnoEntity> getAlumnosByNombre(String nombre);

    @Query("SELECT * FROM " + AlumnoEntity.TABLE_NAME)
    public abstract LiveData<List<AlumnoEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<AlumnoEntity> alumnoEntity);

    /*
    @Query("SELECT * FROM " +MonedaEntity.TABLE_NAME + " WHERE "+MonedaEntity.ID +" = :id")
    public abstract MonedaEntity getMonedaById(Long id);


    @Update
    public abstract void update(MonedaEntity monedaEntity);
     */
}
