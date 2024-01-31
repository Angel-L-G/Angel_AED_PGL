package es.iespuertodelacruz.jc.ejemploretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.iespuertodelacruz.jc.ejemploretrofit.databinding.FragmentAlumnoBinding;
import es.iespuertodelacruz.jc.ejemploretrofit.placeholder.PlaceholderContent.PlaceholderItem;
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
        holder.alumno = alumnos.get(position);
        //holder.mTextData.setText(alumnos.getValue().get(position));
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
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