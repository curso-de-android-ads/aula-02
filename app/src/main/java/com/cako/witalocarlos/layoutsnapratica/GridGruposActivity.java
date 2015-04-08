package com.cako.witalocarlos.layoutsnapratica;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;


public class GridGruposActivity extends ActionBarActivity {

    //O conteúdo desses arrays irão preencher o gridview.
    String[] grupoA = new String[]{"BRASIL", "CROACIA", "CAMAROES", "MEXICO"};
    String[] grupoB = new String[]{"HOLANDA", "ESPANHA", "CHILE", "AUSTRALIA"};
    GridView gvGrupos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_grupos);

        //Recebe a mensagem da Activity anterior
        Bundle extras = getIntent().getExtras();

        //Referencia do adaptador
        ArrayAdapter<String> adapter;

        gvGrupos = (GridView) findViewById(R.id.gv_grupos);

        //Checa se veio realmente alguma mensagem
        if(extras != null){

            //Extrai o valor da mensagem passando a chave
            String valor = extras.getString("grupo");

            //Se o valor extraído for diferente de null, executa o próximo código
            if(valor != null){

                //Se o valor da mensagem for igual a "a", o grid será preenchido com o array A.
                if(valor.equals("a")){
                    adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, grupoA);
                    gvGrupos.setAdapter(adapter);

                    //Se o valor da mensagem for igual a "b", o grid será preenchido com o array B.
                } else if (valor.equals("b")){
                    adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, grupoB);
                    gvGrupos.setAdapter(adapter);
                }
            }
        }

        //Estabelece uma ação quando clicar em um item do grid.
        gvGrupos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //O Toast exibe uma mensagem rápida ao usuário.
                Toast.makeText(getApplicationContext(), "Clicou!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid_grupos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
