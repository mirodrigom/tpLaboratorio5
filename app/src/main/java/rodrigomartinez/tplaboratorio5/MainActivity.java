package rodrigomartinez.tplaboratorio5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick {

    private Vista vista;
    private Controlador controlador;
    //private List<Noticias> listaNoticias;
    private MyAdapter miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vista = new Vista(this);
        this.controlador = new Controlador(this.vista);
        this.vista.getRv().setLayoutManager(new LinearLayoutManager(this));
        miAdaptador = new MyAdapter(this.controlador.getListaNoticias(),this);
        this.vista.getRv().setAdapter(miAdaptador);
    }

    @Override
    public void onItemClick(String link) {
        Log.d("CLICK","Me hizo Click");
    }
}
