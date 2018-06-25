package rodrigomartinez.tplaboratorio5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {

    private Vista vista;
    private List<Noticias> listaNoticias;

    public Controlador(Vista vista)
    {
        this.vista = vista;

        listaNoticias = new ArrayList<Noticias>();
        this.listaNoticias.add(new Noticias("titulo","link","descripcion","imagen",null,new Date(2010-02-02)));
        this.listaNoticias.add(new Noticias("titulo","link","descripcion","imagen",null,new Date(2010-02-02)));
        this.listaNoticias.add(new Noticias("titulo","link","descripcion","imagen",null,new Date(2010-02-02)));
        this.listaNoticias.add(new Noticias("titulo","link","descripcion","imagen",null,new Date(2010-02-02)));
        this.listaNoticias.add(new Noticias("titulo","link","descripcion","imagen",null,new Date(2010-02-02)));

    }

    public List<Noticias> getListaNoticias() {
        return listaNoticias;
    }
}
