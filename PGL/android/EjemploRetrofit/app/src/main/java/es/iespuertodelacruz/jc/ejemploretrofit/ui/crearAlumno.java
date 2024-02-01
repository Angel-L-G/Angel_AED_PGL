package es.iespuertodelacruz.jc.ejemploretrofit.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.R;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.RESTService;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.RetrofitClient;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto.AlumnoDTO;
import es.iespuertodelacruz.jc.ejemploretrofit.viewmodel.ViewModelAlumnos;
import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link crearAlumno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class crearAlumno extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public crearAlumno() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment crearAlumno.
     */
    // TODO: Rename and change types and number of parameters
    public static crearAlumno newInstance(String param1, String param2) {
        crearAlumno fragment = new crearAlumno();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ViewModelAlumnos viewModelAlumnos;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelAlumnos = new ViewModelProvider(this).get(ViewModelAlumnos.class);
        EditText txtDni = view.findViewById(R.id.txtDni);
        EditText txtNombre = view.findViewById(R.id.txtNombre);
        EditText txtEstudios = view.findViewById(R.id.txtEstudios);
        EditText txtFechaNac = view.findViewById(R.id.txtFechaNac);

        Button btnCrearAlumno = view.findViewById(R.id.btnCrearAlumno);

        btnCrearAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlumnoDTO a = new AlumnoDTO();

                String dni = String.valueOf(txtDni.getText());
                String nombre = String.valueOf(txtNombre.getText());
                String estudios = String.valueOf(txtEstudios.getText());
                String fechaStr = ""+txtFechaNac.getText().toString();
                Long fechaNac = Long.parseLong(fechaStr);

                String apellidos = "";
                String foto = "";

                a.setDni(dni);
                a.setApellidos(apellidos);
                a.setEstudios(estudios);
                a.setFoto(foto);
                a.setFechanacimiento(fechaNac);
                a.setNombre(nombre);

                viewModelAlumnos.save(a);

                /*MutableLiveData<List<AlumnoDTO>> mutableAlumnos = new MutableLiveData<>();
                viewModelAlumnos = new ViewModelProvider(requireActivity()).get(ViewModelAlumnos.class);

                RESTService restService = RetrofitClient.getInstance().getRestService();
                Call<AlumnoDTO> deleteCall = restService.doPostAlumnoDTO(a);

                deleteCall.enqueue(new retrofit2.Callback<AlumnoDTO>() {

                    @Override
                    public void onResponse(Call<AlumnoDTO> call, Response<AlumnoDTO> response) {
                        if(response.isSuccessful()) {
                            AlumnoDTO res = response.body();
                            System.out.println("RESPONSE POST: " + res);
                            viewModelAlumnos.alumnos.add(res);
                        }
                    }

                    @Override
                    public void onFailure(Call<AlumnoDTO> call, Throwable t) {
                        System.out.println("Error en la llamada");
                        System.out.println(t.getCause());
                    }
                });*/
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crear_alumno, container, false);
    }
}