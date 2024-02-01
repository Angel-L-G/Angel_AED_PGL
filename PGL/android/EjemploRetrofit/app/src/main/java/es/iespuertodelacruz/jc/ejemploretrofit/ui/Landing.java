package es.iespuertodelacruz.jc.ejemploretrofit.ui;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.R;
import es.iespuertodelacruz.jc.ejemploretrofit.data.db.entity.AlumnoEntity;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto.AlumnoDTO;
import es.iespuertodelacruz.jc.ejemploretrofit.repository.AlumnoRepository;
import es.iespuertodelacruz.jc.ejemploretrofit.viewmodel.ViewModelAlumnos;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Landing#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Landing extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COLUMN_COUNT = "column-count";

    // TODO: Rename and change types of parameters
    private int mColumnCount = 1;

    public Landing() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Landing.
     */
    // TODO: Rename and change types and number of parameters
    public static Landing newInstance(int columnCount) {
        Landing fragment = new Landing();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    ViewModelAlumnos viewModelAlumnos;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_landing, container, false);

        Button btnCrear = view.findViewById(R.id.btnCrear);
        Button btnFiltrar = view.findViewById(R.id.btnFiltrar);


        btnFiltrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_landing_to_verAlumnos);
            }
        });

        btnCrear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_landing_to_crearAlumno);
            }
        });

        return view;
    }

}