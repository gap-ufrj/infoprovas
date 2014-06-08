package br.com.gapwm.Infoprovas.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import android.util.Log;
import br.com.gapwm.Infoprovas.config.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by renan on 20/01/14.
 */
public final class HttpClientHelper {

    //Criando um sigleton
    private static HttpClientHelper instance = new HttpClientHelper();

    //Construtor da classe.
    private HttpClientHelper(){}

    public static HttpClientHelper getInstance(){
        return instance;
    }

    /**
     * Verifica o estado da conexão de acordo com o contexto passado.
     * @param activity contexto em que eu quero saber o estado da conexão.
     * @return
     */
    public static boolean checkNetworkConnection(Context activity){
        ConnectivityManager connectManager = (ConnectivityManager)
                activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectManager.getActiveNetworkInfo();
        if(netInfo!=null && netInfo.isConnected()){
            //Está conectado
            Log.i(Util.getAppName(), "Conectado");
            return true;
        }else{
            //Ocorreu algum erro na conexão
            //TODO tratar os tipos de erro.
            Log.i(Util.getAppName(), "Desconectado");
            return false;
        }
    }

    /**
     * Estabelece uma conexão com o link disponibilizado.
     * @param myUrl link que eu quero conectar
     * @return inputStream com o resultado.
     * @throws IOException
     */
    public InputStream connectUrl(String myUrl)throws IOException{
        InputStream inputStr = null;

        try{
            URL url = new URL(myUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(15000);//milliseconds
            connection.setReadTimeout(10000);//milliseconds
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            connection.connect();

            int response = connection.getResponseCode();
            Log.d(Util.getAppName(), "Resposta da conexão: "+response);
            inputStr = connection.getInputStream();

            return  inputStr;
        }finally {
            if(inputStr!=null){
                inputStr.close();
            }
        }
    }

    /**
     * http://www.learn2crack.com/2013/10/android-json-parsing-url-example.html
     * @param url
     * @return
     */
    public JSONObject getJSONFromUrl(String url){
        return null;
    }

}
