package br.edu.fateczl.vendaingresso;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@author: RODRIGO VINICIUS FERRAZ DA SILVA
 *@RA: 1110482313043
 */

public class ActivityDetalhes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        TextView txtDetalhesCompra = findViewById(R.id.txtDetalhesCompra);

        String codigo = getIntent().getStringExtra("codigo");
        float valorFinal = getIntent().getFloatExtra("valorFinal", 0);

        txtDetalhesCompra.setText("Código do Ingresso: " + codigo + "\nValor Final: " + valorFinal);

        findViewById(R.id.btnVoltar).setOnClickListener(v -> finish());
    }
}

