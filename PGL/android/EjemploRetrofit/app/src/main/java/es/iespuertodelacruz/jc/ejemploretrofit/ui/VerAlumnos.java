package es.iespuertodelacruz.jc.ejemploretrofit.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import es.iespuertodelacruz.jc.ejemploretrofit.R;
import es.iespuertodelacruz.jc.ejemploretrofit.viewmodel.ViewModelAlumnos;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VerAlumnos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VerAlumnos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VerAlumnos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VerAlumnos.
     */
    // TODO: Rename and change types and number of parameters
    public static VerAlumnos newInstance(String param1, String param2) {
        VerAlumnos fragment = new VerAlumnos();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ver_alumnos, container, false);
        viewModelAlumnos = new ViewModelProvider(this).get(ViewModelAlumnos.class);

        EditText txtFiltrar = view.findViewById(R.id.txtFiltrar);
        Button btnFiltrarAlumnos = view.findViewById(R.id.btnFiltrarAlumnos);

        btnFiltrarAlumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelAlumnos.nombreParaFiltrar = txtFiltrar.getText().toString();
                /*
                Codigo Para recargar
                 */
                //Navigation.findNavController(view).navigate(R.id.action_verAlumnos_self);
            }
        });



        return view;
    }
}