package rodrigomartinez.tplaboratorio5;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexionHttp {
    private URL url;
    private HttpURLConnection conexion;
    private byte[] arrayDatos;
    private String strUrl;
    private Integer tamArray;

    public ConexionHttp(String strUrl)
    {
        this.strUrl = strUrl;
        this.url = null;
        this.conexion = null;
        this.arrayDatos = null;
        this.tamArray = 1024;
    }

    public byte[] getDatos()
    {
        try {
            Log.d("URL", this.strUrl);
            this.url = new URL(this.strUrl);
            this.conexion = (HttpURLConnection) this.url.openConnection();
            this.conexion.setRequestMethod("GET");
            this.conexion.connect();
            if(this.conexion.getResponseCode() == 200)
            {
                Log.d("CONEXION","Se ha conectado correctamente.");
                //Abro para escribir
                InputStream is = this.conexion.getInputStream();
                byte[] arr = new byte[tamArray];
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                int len;
                //Mientras el buffer no sea de 1024 sigue, si es -1 no hay nada mas para leer
                while((len = is.read(arr,0,tamArray)) > -1)
                {
                    baos.write(arr,0,len);
                }
                is.close();
                this.arrayDatos = baos.toByteArray();
            }else{
                Log.d("CONEXION", "No se ha podido conectar por alguna razon.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.arrayDatos;
    }

}
