package es.iespto.agl.recyclerView;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import es.iespto.agl.recyclerView.databinding.FragmentPeliculaBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPeliculaRecyclerViewAdapter extends RecyclerView.Adapter<MyPeliculaRecyclerViewAdapter.ViewHolder> {

    private final List<Pelicula> peliculas;
    Context ctx;

    /*public MyPeliculaRecyclerViewAdapter(List<Pelicula> items) {
        peliculas = items;
    }*/

    //PARA GLIDE
    public MyPeliculaRecyclerViewAdapter(Context ctx, List<Pelicula> items) {
        peliculas = items;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPeliculaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = peliculas.get(position);
        holder.mTextViewTitulo.setText(peliculas.get(position).titulo);
        holder.mTextViewDuracion.setText(""+peliculas.get(position).duracion);
        String urlImg = peliculas.get(position).caratula;
        Glide.with(ctx)
                .load(urlImg)
                .into(holder.mImgCaratula);
        //holder.mTextViewCaratula.setText(peliculas.get(position).caratula);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //AQUI PONEMOS LOS OBJETOS GRAFICOS QUE VA A ENLAZAR EL RECYCLER
        public final TextView mTextViewTitulo;
        public final TextView mTextViewDuracion;
        public final ImageView mImgCaratula;
        public Pelicula mItem;

        public ViewHolder(FragmentPeliculaBinding binding) {
            //AQUI LO LINKEAMOS CON EL LAYOUT
            super(binding.getRoot());
            mTextViewTitulo = binding.txtTitulo;
            mTextViewDuracion = binding.txtDuracion;
            mImgCaratula = binding.imgCaratula;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextViewTitulo.getText() + "'";
        }
    }
}