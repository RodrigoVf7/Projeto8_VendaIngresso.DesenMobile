package br.edu.fateczl.vendaingresso;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.*;

/*
 *@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043
 */

public class MainActivity extends AppCompatActivity {
    private EditText editCodigo, editValor, editTaxa, editFuncaoComprador;
    private RadioGroup radioGroupTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo = findViewById(R.id.editCodigo);
        editValor = findViewById(R.id.editValor);
        editTaxa = findViewById(R.id.editTaxa);
        editFuncaoComprador = findViewById(R.id.editFuncaoComprador);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);

        radioGroupTipo.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioVip) {
                editFuncaoComprador.setVisibility(View.VISIBLE);
            } else {
                editFuncaoComprador.setVisibility(View.GONE);
            }
        });

        findViewById(R.id.btnCalcular).setOnClickListener(v -> calcularValor());
    }

    private void calcularValor() {
        String codigo = editCodigo.getText().toString();
        float valor = Float.parseFloat(editValor.getText().toString());
        float taxa = Float.parseFloat(editTaxa.getText().toString());

        boolean isVip = radioGroupTipo.getCheckedRadioButtonId() == R.id.radioVip;
        float valorFinal;

        if (isVip) {
            String funcao = editFuncaoComprador.getText().toString();
            IngressoVIP ingressoVIP = new IngressoVIP(codigo, valor, funcao);
            valorFinal = ingressoVIP.valorFinal(taxa);
        } else {
            Ingresso ingresso = new Ingresso(codigo, valor);
            valorFinal = ingresso.valorFinal(taxa);
        }

        Intent intent = new Intent(this, ActivityDetalhes.class);
        intent.putExtra("codigo", codigo);
        intent.putExtra("valorFinal", valorFinal);
        startActivity(intent);
    }
}
