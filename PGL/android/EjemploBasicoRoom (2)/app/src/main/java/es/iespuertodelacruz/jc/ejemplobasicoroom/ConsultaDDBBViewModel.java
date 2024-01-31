package es.iespuertodelacruz.jc.ejemplobasicoroom;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

//public class ConsultaDDBBViewModel extends ViewModel {


//¡¡¡¡¡ importante !!!!! observar que hay que extender de AndroidViewModel
//en lugar de ViewModel para poder tener el contexto
public class ConsultaDDBBViewModel extends AndroidViewModel
{
    // TODO: Implement the ViewModel

    LiveData<List<PersonaEntity>> asyncGetAll(){
        return  personaDAO.asyncGetAll();
    }

    PersonaDAO personaDAO;
    public ConsultaDDBBViewModel(Application application){
        super(application);

        //observar que hay que usar application.getApplicationContext() en lugar de:
        //getActivity().getApplicationContext()
        DatabasePersonas database = DatabasePersonas.getDatabase(application.getApplicationContext());
        personaDAO = database.personaDAO();

    }
}