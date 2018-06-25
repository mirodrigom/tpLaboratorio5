package rodrigomartinez.tplaboratorio5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView tituloNoticia;
    public TextView descripcionNoticia;
    public ImageView imagenNoticia;
    public TextView fechaNoticia;
    public byte[] imagenByte;

    private String link;

    private MyOnItemClick listener;


    public MyViewHolder(View itemView, MyOnItemClick listener) {
        super(itemView);
        this.tituloNoticia = (TextView) itemView.findViewById(R.id.tituloNoticia);
        this.descripcionNoticia = (TextView) itemView.findViewById(R.id.descripcionNoticia);
        this.imagenNoticia = (ImageView) itemView.findViewById(R.id.imgNoticia);
        this.fechaNoticia = (TextView) itemView.findViewById(R.id.fechaNoticia);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    public String getLink(){
        return this.link;
    }

    public void setLink(String link)
    {
        this.link =  link;
    }

    @Override
    public void onClick(View v) {
        this.listener.onItemClick(link);
    }
}
