package es.iespuertodelacruz.jc.ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("---------------------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MutableLiveData<AlumnoDTO> mutableAlumnos = new MutableLiveData<>();

        RESTService restService = RetrofitClient.getInstance().getRestService();
        retrofit2.Call<AlumnoDTO> callPerros = restService.doGetAlumnosDTO();
        System.out.println("---------------------------------------");
        callPerros.enqueue(new retrofit2.Callback<AlumnoDTO>() {
            @Override
            public void onResponse(Call<AlumnoDTO> call, retrofit2.Response<AlumnoDTO> response) {
                if(response.isSuccessful()) {
                    AlumnoDTO alumnos = response.body();
                    System.out.println("---------------------------------------");
                    mutableAlumnos.setValue(alumnos);
                }
            }

            @Override
            public void onFailure(Call<AlumnoDTO> call, Throwable t) {
                System.out.println("Error en la llamada");
                System.out.println(t.getMessage());
            }
        });
        System.out.println("---------------------------------------");
        //ponemos this en owner pero si esto fuera un fragment: getViewLifecycleOwner()
        mutableAlumnos.observe( this, perro -> {
            System.out.println("recibido  query retrofit:_____________________________ " +perro);
        });

        TextView txtRes = findViewById(R.id.txtRes);
        txtRes.setText(mutableAlumnos.getValue().toString());
    }
}