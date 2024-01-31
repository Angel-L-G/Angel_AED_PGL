package es.iespuertodelacruz.jc.ejemplobasicoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        DatabasePersonas database = DatabasePersonas.getDatabase(getApplicationContext());
        PersonaDAO personaDAO = database.personaDAO();
        */

        //personaDAO.insert(new PersonaEntity("ana",23));

        //List<PersonaEntity> personas = personaDAO.getAll();
        //System.out.println("lista personas:_____________________________ " +personas);

        /*
        //en lugar de this se use getLifecycleOwner() si estamos en un fragment
        personaDAO.asyncGetAll().observe(   this, personas -> {
            System.out.println("lista personas query ASINCRONA:_____________________________ " +personas);
        });
*/

        ListenableFuture<Long> futureListener = personaDAO.insertAsync(new PersonaEntity("linda", 38));

        Executor listeningExecutor = Executors.newSingleThreadExecutor();
        Futures.addCallback(futureListener, new FutureCallback<Long>() {
            @Override
            public void onSuccess(Long result) {
                System.out.println("insertado con id::::::::::::::::::::::::::::::::::::::::::::::::::. "+ result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Ha habido fallo !");
            }
        }, listeningExecutor);


    }
}