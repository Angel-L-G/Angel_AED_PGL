package es.iespuertodelacruz.jc.ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
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

        TextView txtRes = findViewById(R.id.txtRes);

        mutableAlumnos.observe(this, al -> {
            txtRes.append(al.toString());
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAA ---- " + al);
        });
        */
    }
}