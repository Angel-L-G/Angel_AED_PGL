package es.iespto.agl.room_1;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(
        entities = {
                Alumno.class,
        }, version = 1
        , exportSchema = false
)
public abstract class DatabaseAlumnos extends androidx.room.RoomDatabase{
        abstract public AlumnoDAO alumnoDAO();
        //abstract public HistoricoDAO historicoDAO();
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