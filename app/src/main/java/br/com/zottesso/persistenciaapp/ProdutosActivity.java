package br.com.zottesso.persistenciaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ProdutosActivity extends AppCompatActivity {

    private ListView textProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        textProdutos = (ListView) findViewById(R.id.textProdutos);

        // Buscar todos os produtos do banco
        List<Produto> produtos = Produto.listAll(Produto.class);
        String[] nomes = new String[produtos.size()];


        for (int i = 0; i < produtos.size(); i++) {
            nomes[i] = produtos.get(i).getNome() + " valor: "+ produtos.get(i).getValor();
        }


        // Define o texto no textview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        textProdutos.setAdapter(adapter);
    }
}
