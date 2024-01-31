package es.iespuertodelacruz.jc.ejemploretrofit.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.data.db.DatabaseAlumnos;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.dao.AlumnoDao;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity.AlumnoEntity;

public class AlumnoRepository {
    private AlumnoDao alumnoDAO;
    public AlumnoRepository(Application application){
        DatabaseAlumnos database = DatabaseAlumnos.getDatabase(application);
        alumnoDAO = database.alumnoDAO();
    }
    public void insert(AlumnoEntity alumnoEntity){
        new insertAsyncTask(alumnoDAO).execute(alumnoEntity);
    }

    public LiveData<List<AlumnoEntity>> getAll() {
        return alumnoDAO.getAll();
    }
    private static class insertAsyncTask extends android.os.AsyncTask<AlumnoEntity, Void, Void> {
        private AlumnoDao mAsyncTaskDao;
        insertAsyncTask(AlumnoDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final AlumnoEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
