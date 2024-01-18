package es.iespto.agl.room_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_todos_activity);

        DatabaseAlumnos database = DatabaseAlumnos.getDatabase(getApplicationContext());
        AlumnoDAO alumnoDao = database.alumnoDAO();

        Long a = alumnoDao.insert(new Alumno("87654321Z", "ana", 23));
        System.out.println("//////////////////////////" + a);

        List<Alumno> alumnos = alumnoDao.getAll();
        System.out.println("lista personas:_____________________________ " +alumnos);
    }
}