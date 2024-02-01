package es.iespuertodelacruz.jc.ejemploretrofit.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.data.NetworkBoundResource;
import es.iespuertodelacruz.jc.ejemploretrofit.data.Resource;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.DatabaseAlumnos;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.dao.AlumnoDao;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity.AlumnoEntity;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.RESTService;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.RetrofitClient;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto.AlumnoDTO;
import retrofit2.Call;

public class AlumnoRepository {
    private AlumnoDao alumnoDAO;
    RESTService restService;
    private DatabaseAlumnos database;

    public AlumnoRepository(Application application) {
        database = DatabaseAlumnos.getDatabase(application);
        alumnoDAO = database.alumnoDAO();
        restService = RetrofitClient.getInstance().getRestService();
    }

    public List<AlumnoDTO> findAll() {
        LiveData<List<AlumnoEntity>> all = alumnoDAO.getAll();

        List<AlumnoDTO> lista = new ArrayList();
        for (AlumnoEntity a: all.getValue()) {
            AlumnoDTO ae = new AlumnoDTO();

            ae.setFechanacimiento(a.getFechanacimiento());
            ae.setEstudios(a.getEstudios());
            ae.setDni(a.getDni());
            ae.setNombre(a.getNombre());

            lista.add(ae);
        }

        return lista;
    }

    public Long insert(AlumnoDTO a) {
        AlumnoEntity ae = new AlumnoEntity();

        ae.setFechanacimiento(a.getFechanacimiento());
        ae.setEstudios(a.getEstudios());
        ae.setDni(a.getDni());
        ae.setNombre(a.getNombre());

        return alumnoDAO.insert(ae);
    }

    public void insertAll(List<AlumnoDTO> alumnos) {
        List lista = new ArrayList();

        for (AlumnoDTO a: alumnos) {
            AlumnoEntity ae = new AlumnoEntity();

            ae.setFechanacimiento(a.getFechanacimiento());
            ae.setEstudios(a.getEstudios());
            ae.setDni(a.getDni());
            ae.setNombre(a.getNombre());

            lista.add(ae);
        }

        alumnoDAO.insertAll(lista);
    }

    public void delete(AlumnoDTO a) {
        AlumnoEntity ae = new AlumnoEntity();

        ae.setFechanacimiento(a.getFechanacimiento());
        ae.setEstudios(a.getEstudios());
        ae.setDni(a.getDni());
        ae.setNombre(a.getNombre());

        alumnoDAO.delete(ae);
    }

    public List<AlumnoDTO> getByName(String n) {
        List<AlumnoEntity> alumnosByNombre = alumnoDAO.getAlumnosByNombre(n);
        return null;
    }

    /*public LiveData<Resource<List<AlumnoEntity>>> getLiveDataMonedas() {
        return new NetworkBoundResource<List<AlumnoEntity>, List<AlumnoDTO>>() {
            @Override
            protected void saveCallResult(@NonNull List<AlumnoDTO> alumnosDTO) {
                //este método se ejecuta adicionalmente cuando hay éxito en la consulta a la api remota
                //así que se ejecuta justo después de createCall()
                //y guarda la información en la base de datos local para futuras consultas
                ArrayList<AlumnoEntity> alumnoEntityList = new ArrayList<>();
                for (AlumnoDTO alumnoDTO : alumnosDTO) {
                    AlumnoEntity alumnoEntity = new AlumnoEntity();

                    alumnoEntity.setNombre(alumnoDTO.getNombre());
                    alumnoEntity.setDni(alumnoDTO.getDni());
                    alumnoEntity.setEstudios(alumnoDTO.getEstudios());
                    alumnoEntity.setFechanacimiento(alumnoDTO.getFechanacimiento());

                    alumnoEntityList.add(alumnoEntity);
                }

                alumnoDAO.insertAll(alumnoEntityList);
            }
            @NonNull
            @Override
            protected LiveData<List<AlumnoEntity>> loadFromDb() {
                //se acude a este método en caso de fallo en la consulta a la api remota y
                //devuelve la lista de monedas de la base de datos local
                return alumnoDAO.getAll();
            }
            @NonNull
            @Override
            protected Call<List<AlumnoDTO>> createCall() {
                //Devuelve la lista de monedas de la base de la api remota.
                //primero se ejecuta este método, si falla, se ejecuta el método loadFromDb.
                //si tiene éxito, se ejecuta el método saveCallResult
                return restService.doGetAlumnosDTO();
            }
        }.getAsLiveData();
    }*/

}
