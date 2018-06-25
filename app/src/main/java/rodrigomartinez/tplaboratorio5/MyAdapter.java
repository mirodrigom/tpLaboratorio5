package rodrigomartinez.tplaboratorio5;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.logging.Handler;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{

    private List<Noticias> listaNoticias;
    private MyOnItemClick listener;

    public MyAdapter(List<Noticias> listaNoticias, MyOnItemClick listener)
    {
        this.listaNoticias = listaNoticias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v, this.listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Noticias noticia = this.listaNoticias.get(position);
        holder.tituloNoticia.setText(noticia.getTitulo());
        holder.descripcionNoticia.setText(noticia.getDescripcion());
        //holder.imagenNoticia.setImageBitmap(BitmapFactory.decodeByteArray(noticia.getImagenByte(), 0, noticia.getImagenByte().length));
        holder.fechaNoticia.setText(noticia.castDateToString(noticia.getFecha()));
    }

    @Override
    public int getItemCount() {
        return this.listaNoticias.size();
    }
}
