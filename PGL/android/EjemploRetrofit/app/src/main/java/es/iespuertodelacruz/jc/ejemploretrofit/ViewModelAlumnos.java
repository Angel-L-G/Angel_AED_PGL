package es.iespuertodelacruz.jc.ejemploretrofit;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.AlumnoDTO;

public class ViewModelAlumnos extends ViewModel {
    public List<AlumnoDTO> alumnos = new ArrayList<>();
    public List<AlumnoDTO> alumnosFiltrados = new ArrayList<>();
}
