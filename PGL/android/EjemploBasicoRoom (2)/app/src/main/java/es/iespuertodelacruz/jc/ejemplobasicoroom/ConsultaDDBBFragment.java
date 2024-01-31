package es.iespuertodelacruz.jc.ejemplobasicoroom;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConsultaDDBBFragment extends Fragment {

    private ConsultaDDBBViewModel mViewModel;

    public static ConsultaDDBBFragment newInstance() {
        return new ConsultaDDBBFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_consulta_ddbb, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ConsultaDDBBViewModel.class);


        DatabasePersonas database = DatabasePersonas.getDatabase(getActivity().getApplicationContext());
        PersonaDAO personaDAO = database.personaDAO();

        //en un fragment se usa getViewLifecycleOwner()
        personaDAO.asyncGetAll().observe(   getViewLifecycleOwner(), personas -> {
            System.out.println("lista personas query ASINCRONA:_____________________________ " +personas);
        });




        //observar que ahora la petición se hace en el viewmodel:
        mViewModel.asyncGetAll().observe( getViewLifecycleOwner(), personas -> {
            System.out.println("lista personas query ASINCRONA en un VIEWMODEL:_____________________________ " +personas);
        });



    }



}