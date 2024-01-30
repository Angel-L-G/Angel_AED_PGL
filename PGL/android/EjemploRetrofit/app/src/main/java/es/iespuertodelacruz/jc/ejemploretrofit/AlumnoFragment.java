package es.iespuertodelacruz.jc.ejemploretrofit;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.placeholder.PlaceholderContent;
import retrofit2.Call;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 */
public class AlumnoFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AlumnoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AlumnoFragment newInstance(int columnCount) {
        AlumnoFragment fragment = new AlumnoFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alumno_list, container, false);

        MutableLiveData<List<AlumnoDTO>> all = findAll();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyAlumnoRecyclerViewAdapter(context, all));
        }
        return view;
    }

    public MutableLiveData<List<AlumnoDTO>> findAll(){
        MutableLiveData<List<AlumnoDTO>> mutableAlumnos = new MutableLiveData<>();

        RESTService restService = RetrofitClient.getInstance().getRestService();
        retrofit2.Call<List<AlumnoDTO>> callAlumnos = restService.doGetAlumnosDTO();
        callAlumnos.enqueue(new retrofit2.Callback<List<AlumnoDTO>>() {

            @Override
            public void onResponse(Call<List<AlumnoDTO>> call, Response<List<AlumnoDTO>> response) {
                if(response.isSuccessful()) {
                    List alumnos = response.body();

                    mutableAlumnos.setValue(alumnos);
                }
            }

            @Override
            public void onFailure(Call<List<AlumnoDTO>> call, Throwable t) {
                System.out.println("Error en la llamada");
                System.out.println(t.getCause());
            }
        });

        return mutableAlumnos;
    }
}