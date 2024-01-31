package es.iespuertodelacruz.jc.ejemplobasicoroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public abstract class PersonaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract Long insert(PersonaEntity personaEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract ListenableFuture<Long> insertAsync(PersonaEntity personaEntity);


    @Query("SELECT * FROM " + PersonaEntity.TABLE_NAME)
    public abstract List<PersonaEntity> getAll();

    @Query("SELECT * FROM " + PersonaEntity.TABLE_NAME)
    public abstract LiveData<List<PersonaEntity>> asyncGetAll();
}
