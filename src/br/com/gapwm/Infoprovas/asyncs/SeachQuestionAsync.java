package br.com.gapwm.Infoprovas.asyncs;

import android.os.AsyncTask;
import android.widget.Toast;
import br.com.gapwm.Infoprovas.helper.HttpClientHelper;

import java.io.IOException;

/**
 * Created by renan on 20/01/14.
 */
public class SeachQuestionAsync extends AsyncTask<Void, Void, Void>{


    @Override
    protected Void doInBackground(Void... params) {
        HttpClientHelper httpCH = HttpClientHelper.getInstance();
        try {
            httpCH.connectUrl("http://www.google.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void o) {
        super.onPostExecute(o);
    }
}
