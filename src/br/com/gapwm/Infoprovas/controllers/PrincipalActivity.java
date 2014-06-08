package br.com.gapwm.Infoprovas.controllers;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import br.com.gapwm.Infoprovas.R;
import br.com.gapwm.Infoprovas.fragments.PesquisaFragment;

/**
 * Created by renan on 19/01/14.
 * Para usar o modo de compatibilidade do android para a actionbar
 * http://stackoverflow.com/questions/20927200/dependency-handling-for-android-project-in-intellij-idea
 * http://stackoverflow.com/questions/18025942/how-do-i-add-a-library-android-support-v7-appcompat-in-intellij-idea
 * ActionBarActivity é uma subclasse de FragmentActivity
 */
public class PrincipalActivity extends ActionBarActivity {

    private SearchView mSearchView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_screen);

        //Apenas um teste para saber se há um frameLayout (que suporta a utilização de fragments)
        if(findViewById(R.id.base_screen_frame) != null){
            //Se estamos vindo de um estado anterior, não precisamos fazer nada.
            if(savedInstanceState != null){
                return;
            }
            PesquisaFragment pesquisaFragment = new PesquisaFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.base_screen_frame, pesquisaFragment).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        //http://developer.android.com/training/basics/actionbar/adding-buttons.html
        // o res-auto é o package do app
        //inflater.inflate(R.menu.base_menu, menu);

        //http://antonioleiva.com/actionbarcompat-action-views/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_action_search:
                //http://stackoverflow.com/questions/17902308/null-pointer-exception-in-searchview
                //mSearchView.setIconified(false);
                return true;
        }

        return false;
    }
}