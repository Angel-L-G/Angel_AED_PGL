package es.iespto.agl.room_1;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.iespto.agl.room_1.placeholder.PlaceholderContent.PlaceholderItem;
import es.iespto.agl.room_1.databinding.FragmentAlumnoBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAlumnoRecyclerViewAdapter extends RecyclerView.Adapter<MyAlumnoRecyclerViewAdapter.ViewHolder> {

    private final List<Alumno> alumnos;
    Context ctx;

    public MyAlumnoRecyclerViewAdapter(Context ctx, List<Alumno> items) {
        alumnos = items;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentAlumnoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = alumnos.get(position);
        holder.mTxtDni.setText(alumnos.get(position).getDni());
        holder.mTxtEdad.setText(alumnos.get(position).getEdad());
        holder.mTxtNombre.setText(alumnos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTxtDni;
        public final TextView mTxtNombre;
        public final TextView mTxtEdad;
        public Alumno mItem;

        public ViewHolder(FragmentAlumnoBinding binding) {
            super(binding.getRoot());
            mTxtNombre = binding.txtNombre;
            mTxtDni = binding.txtDni;
            mTxtEdad = binding.txtEdad;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTxtDni.getText() + "'" + " '" + mTxtNombre.getText() + "'" + " '" + mTxtEdad.getText() + "'";
        }
    }
}