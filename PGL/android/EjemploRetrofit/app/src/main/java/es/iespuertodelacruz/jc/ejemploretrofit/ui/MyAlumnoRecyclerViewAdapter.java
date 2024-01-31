package es.iespuertodelacruz.jc.ejemploretrofit.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.R;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.RESTService;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.RetrofitClient;
import es.iespuertodelacruz.jc.ejemploretrofit.data.rest.dto.AlumnoDTO;
import es.iespuertodelacruz.jc.ejemploretrofit.databinding.FragmentAlumnoBinding;
import es.iespuertodelacruz.jc.ejemploretrofit.placeholder.PlaceholderContent.PlaceholderItem;
import es.iespuertodelacruz.jc.ejemploretrofit.viewmodel.ViewModelAlumnos;
import retrofit2.Call;
import retrofit2.Response;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAlumnoRecyclerViewAdapter extends RecyclerView.Adapter<MyAlumnoRecyclerViewAdapter.ViewHolder> {

    private List<AlumnoDTO> alumnos;
    private Context ctx;

    public MyAlumnoRecyclerViewAdapter(Context ctx, List<AlumnoDTO> alumnos) {
        this.ctx = ctx;
        this.alumnos = alumnos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentAlumnoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    ViewModelAlumnos viewModelAlumnos;

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        int pos = position;
        holder.alumno = alumnos.get(position);
        holder.mTextData.setText(alumnos.get(position).toString());

        holder.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutableLiveData<List<AlumnoDTO>> mutableAlumnos = new MutableLiveData<>();

                RESTService restService = RetrofitClient.getInstance().getRestService();
                Call<String> deleteCall = restService.doDeleteAlumnoDTO(alumnos.get(pos).getDni());

                NavController navController = Navigation.findNavController((Activity) ctx, R.id.fragmentContainerView4);
                deleteCall.enqueue(new retrofit2.Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful()) {
                            String res = response.body();
                            System.out.println("RESPONSE DELETE: " + res);

                            navController.navigate(R.id.action_verAlumnos_self);
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        navController.navigate(R.id.action_verAlumnos_self);
                        System.out.println("Error en la llamada");
                        System.out.println(t.getCause());
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return alumnos==null?0:alumnos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextData;
        public final Button btnBorrar;
        public AlumnoDTO alumno;

        public ViewHolder(FragmentAlumnoBinding binding) {
            super(binding.getRoot());
            mTextData = binding.txtData;
            btnBorrar = binding.btnBorrar;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextData.getText() + "'";
        }
    }
}