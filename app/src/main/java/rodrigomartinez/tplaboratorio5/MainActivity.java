package rodrigomartinez.tplaboratorio5;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick, Handler.Callback {

    private Vista vista;
    private Controlador controlador;
    //private List<Noticias> listaNoticias;
    private MyAdapter miAdaptador;
    private Handler miHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vista = new Vista(this);
        this.controlador = new Controlador(this.vista);
        this.vista.getRv().setLayoutManager(new LinearLayoutManager(this));
        miAdaptador = new MyAdapter(this.controlador.getListaNoticias(),this);
        this.vista.getRv().setAdapter(miAdaptador);
        this.miHandler = new Handler(this);


        HiloDatos hilo = new HiloDatos("https://help.ubnt.com/hc/en-us/articles/220066768-UniFi-How-to-Install-Update-via-APT-on-Debian-or-Ubuntu", this.miHandler);
        Thread t1 = new Thread(hilo);
        t1.start();

    }

    @Override
    public void onItemClick(String link) {
        Log.d("CLICK","Me hizo Click");
    }

    @Override
    public boolean handleMessage(Message msg)
    {

        return false;
    }
}
