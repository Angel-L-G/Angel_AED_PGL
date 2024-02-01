package es.iespuertodelacruz.jc.ejemploretrofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity.AlumnoEntity;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto.AlumnoDTO;
import es.iespuertodelacruz.jc.ejemploretrofit.repository.AlumnoRepository;

public class ViewModelAlumnos extends AndroidViewModel {
    public List<AlumnoDTO> alumnos = new ArrayList<>();
    public List<AlumnoDTO> alumnosFiltrados = new ArrayList<>();
    public String nombreParaFiltrar;

    AlumnoRepository alumnoRepository;

    public ViewModelAlumnos(@NonNull Application application) {
        super(application);
        alumnoRepository = new AlumnoRepository(application);
    }

    public LiveData<List<AlumnoEntity>> getAll(){
        return alumnoRepository.findAll();
    }

    public void filter(){
        alumnosFiltrados = alumnos.stream()
            .filter(objeto -> objeto.getNombre().contains(nombreParaFiltrar))
            .collect(Collectors.toList());
    }

    public void save(AlumnoDTO a){
        alumnoRepository.insert(a);
        //getAll();
    }

    public void saveAll(List<AlumnoDTO> list){
        alumnoRepository.insertAll(list);
        //getAll();
    }

    public void delete(AlumnoDTO a){
        alumnoRepository.delete(a);
    }
}
