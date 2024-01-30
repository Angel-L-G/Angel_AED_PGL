package es.iespuertodelacruz.jc.ejemploretrofit;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import es.iespuertodelacruz.jc.ejemploretrofit.placeholder.PlaceholderContent.PlaceholderItem;
import es.iespuertodelacruz.jc.ejemploretrofit.databinding.FragmentAlumnoBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAlumnoRecyclerViewAdapter extends RecyclerView.Adapter<MyAlumnoRecyclerViewAdapter.ViewHolder> {

    private final MutableLiveData<List<AlumnoDTO>> alumnos;
    private Context ctx;

    public MyAlumnoRecyclerViewAdapter(Context ctx, MutableLiveData<List<AlumnoDTO>> items) {
        this.ctx = ctx;
        alumnos = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentAlumnoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.alumno = alumnos.getValue().get(position);
        //holder.mTextData.setText(alumnos.getValue().get(position));
    }

    @Override
    public int getItemCount() {
        return alumnos.getValue().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextData;
        public final Button btnBorrar;
        public AlumnoDTO alumno;

        public ViewHolder(FragmentAlumnoBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}