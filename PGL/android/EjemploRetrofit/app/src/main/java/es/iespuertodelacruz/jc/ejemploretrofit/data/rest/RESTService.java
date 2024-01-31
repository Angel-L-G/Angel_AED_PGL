package es.iespuertodelacruz.jc.ejemploretrofit.data.rest;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto.AlumnoDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RESTService {
    @GET("alumnos")
    Call<List<AlumnoDTO>> doGetAlumnosDTO();

    @POST("alumnos")
    Call<AlumnoDTO> doPostAlumnoDTO(@Body AlumnoDTO alumno);

    @DELETE("alumnos/{id}")
    Call<String> doDeleteAlumnoDTO(@Path("id") String id);
}
