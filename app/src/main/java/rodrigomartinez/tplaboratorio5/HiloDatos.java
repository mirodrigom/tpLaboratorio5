package rodrigomartinez.tplaboratorio5;

import android.os.Message;
import android.os.Handler;

import java.io.UnsupportedEncodingException;

public class HiloDatos implements Runnable{

    private String url;
    private android.os.Handler handler;

    public HiloDatos(String url, Handler handler)
    {
        this.url = url;
        this.handler = handler;
    }

    @Override
    public void run() {
        if(Thread.interrupted())
        {
            return;
        }

        ConexionHttp conexion = new ConexionHttp(this.url);
        byte[] datos = conexion.getDatos();
        Message msg = new Message();
        try {
            msg.obj = new String(datos, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.handler.sendMessage(msg);
    }
}
