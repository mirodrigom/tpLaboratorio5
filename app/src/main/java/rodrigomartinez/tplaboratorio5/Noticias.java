package rodrigomartinez.tplaboratorio5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Noticias {
    private String titulo;
    private String link;
    private String descripcion;
    private String imagen;
    private byte[] imagenByte;
    private Date fecha;

    public Noticias()
    {
    }

    public Noticias(String tit, String lin, String des, String ima, byte[] imb, Date fec){
        this.titulo = tit;
        this.link = lin;
        this.descripcion = des;
        this.imagen = ima;
        this.imagenByte = imb;
        this.fecha = fec;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagenByte() {
        return imagenByte;
    }

    public void setImagenByte(byte[] imagenByte) {
        this.imagenByte = imagenByte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /*
    Funciones
     */

    public String castDateToString(Date fecha)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MMM-yyyy");
        return formatoFecha.format(fecha);
    }
}
