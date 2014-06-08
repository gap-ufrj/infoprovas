package br.com.gapwm.Infoprovas.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import br.com.gapwm.Infoprovas.R;
import br.com.gapwm.Infoprovas.asyncs.SeachQuestionAsync;
import br.com.gapwm.Infoprovas.helper.HttpClientHelper;

/**
 * Created by renan on 20/01/14.
 */
public class PesquisaFragment extends Fragment {

    RadioButton opcaoProfessor;
    RadioButton opcaoDisciplina;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(HttpClientHelper.checkNetworkConnection(this.getActivity())){
            SeachQuestionAsync asyncQuery = new SeachQuestionAsync();
            asyncQuery.execute();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View screen = inflater.inflate(R.layout.pesquisa_frag, container, false);

        opcaoProfessor = (RadioButton) screen.findViewById(R.id.pesquisa_radio_professor);
        opcaoDisciplina = (RadioButton) screen.findViewById(R.id.pesquisa_radio_disciplina);
        configuraViews();

        return screen;
    }

    private void configuraViews(){
        opcaoProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
        opcaoDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.pesquisa_radio_professor:
                if (checked)
                    opcaoDisciplina.setChecked(false);
                    break;
            case R.id.pesquisa_radio_disciplina:
                if (checked)
                    opcaoProfessor.setChecked(false);
                    break;
        }
    }


}