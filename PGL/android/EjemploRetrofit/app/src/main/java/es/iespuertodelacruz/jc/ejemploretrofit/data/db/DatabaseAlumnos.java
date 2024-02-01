package es.iespuertodelacruz.jc.ejemploretrofit.data.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import es.iespuertodelacruz.jc.ejemploretrofit.data.db.dao.AlumnoDao;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity.AlumnoEntity;

@androidx.room.Database(
        entities = {
                AlumnoEntity.class
        }, version = 1
        , exportSchema = false
)
@TypeConverters({ /*Converters.class */})
public abstract class DatabaseAlumnos extends androidx.room.RoomDatabase{
    abstract public AlumnoDao alumnoDao();
    private static volatile DatabaseAlumnos INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static DatabaseAlumnos getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseAlumnos.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DatabaseAlumnos.class, "alumnos.db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
