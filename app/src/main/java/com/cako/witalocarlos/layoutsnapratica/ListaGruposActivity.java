package com.cako.witalocarlos.layoutsnapratica;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListaGruposActivity extends ListActivity {

    //Nesse caso criaremos o layout em tempo de execução, então excluímos o método setContentView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Array que irá preencher a lista.
        String[] grupos = new String[]{"Grupo A", "Grupo B", "Grupo C", "Grupo D",
                                        "Grupo E", "Grupo F", "Grupo G", "Grupo H"};

        //Array adaptador que irá preencher o listview com o array grupos.
        // para isso, setamos o contexto do adaptador, que no nosso caso é o escopo atual, então utilizamos 'this'
        // depois setamos o modelo em que o texto aparecerá na tela, para isso utilizamos um modelo pré-definido pelo Android.
        // e finalmente dizemos qual array queremos adaptar na lista.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grupos);

        //Com o adaptador pronto, setamos o adaptador na lista.
        setListAdapter(adapter);
    }

    //Método para realizar uma ação quando clicarmos em um item da lista.
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id ){

        //a variável item recebe o valor contido na item da lista que o usuário clicou.
        String item = (String) getListAdapter().getItem(position);

        //dependendo do valor o gridview na activity seguinte irá ser preenchido com um array específico.
        switch (item){
            case "Grupo A":
                //Aqui estamos dizendo que: sairemos dessa activity ("this") para a próxima (GridGruposActivity.class) e mandando uma mensagem ("a")
                trocaTela(this, GridGruposActivity.class, "a");
                break;
            case "Grupo B":
                trocaTela(this, GridGruposActivity.class, "b");
                break;
            default:
                Toast.makeText(this, "Nada Aqui", Toast.LENGTH_LONG).show();
        }
    }

    //Método responsável pela troca de telas.
    private void trocaTela(Context context, Class<?> clazz, String extra){
        Intent intent = new Intent(context, clazz);

        //Ao trocar de telas, uma mensagem é enviada a activity destino.
        intent.putExtra("grupo",extra);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_grupos, menu);
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
