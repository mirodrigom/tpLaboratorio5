package rodrigomartinez.tplaboratorio5;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parser {
        private static List<Noticias> listaNoticias;

        public static List<Noticias> ParsearTelam(String xmlToParse)
        {
            String webpageTelam = "http://www.telam.com.ar";
            String titulo;
            String link;
            String imagen;
            String descripcion;
            String fecha;

            XmlPullParser xml = Xml.newPullParser();

            try {
                xml.setInput(new StringReader(xmlToParse));
                int event = xml.getEventType();
                Noticias nuevaNoticia = null;
                while(event != XmlPullParser.END_DOCUMENT)
                {
                    switch (event)
                    {
                        case XmlPullParser.START_DOCUMENT:
                            listaNoticias = new ArrayList<Noticias>();
                            break;

                        case XmlPullParser.START_TAG:
                            if(xml.getName().equalsIgnoreCase("item"))
                            {
                                nuevaNoticia = new Noticias();
                            }else if(nuevaNoticia != null) {
                                if (xml.getName().equalsIgnoreCase("title"))
                                {
                                    nuevaNoticia.setTitulo(xml.nextText());
                                }
                                else if(xml.getName().equalsIgnoreCase("link"))
                                {
                                    nuevaNoticia.setLink(webpageTelam + xml.nextText());
                                }
                                else if(xml.getName().equalsIgnoreCase("description"))
                                {
                                    nuevaNoticia.setDescripcion(xml.nextText());
                                }
                                else if(xml.getName().equalsIgnoreCase("pubDate"))
                                {
                                    nuevaNoticia.setFecha(nuevaNoticia.castStringToDate(xml.nextText(),"dd MMM yyyy"));
                                }
                                else if(xml.getName().equalsIgnoreCase("enclosure"))
                                {
                                    nuevaNoticia.setImagen(xml.getAttributeValue(null,"url"));
                                }
                            }
                            break;

                        case XmlPullParser.END_TAG:
                            //termino un item
                            if(xml.getName().equalsIgnoreCase("item") && nuevaNoticia != null)
                            {
                                listaNoticias.add(nuevaNoticia);
                            }
                            break;
                    }
                    event = xml.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
                return listaNoticias;
        }

        public static List<Noticias> ParsearJSON(String texto)
        {
            return null;
        }

}
