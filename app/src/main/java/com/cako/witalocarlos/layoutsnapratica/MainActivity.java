package com.cako.witalocarlos.layoutsnapratica;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {


    Button btListGrid;
    Button btLayoutsAninhados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associando os elementos XML ao objeto Java
        btListGrid = (Button) findViewById(R.id.bt_list_grid);
        btLayoutsAninhados = (Button) findViewById(R.id.bt_layouts_aninhados);

        //Adicionando uma ação ao botão.
        btListGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //A ação deste botão será para trocar de activitys. para isso, utilizamos um Intent.
                // Intent demonstra uma intenção de realizar uma ação, no nosso caso, nossa intenção é trocar de tela.
                // Para isso é necessário dizer qual o escopo atual (getAplicationContext) e dizer qual a activity destino (ListaGruposActivity.class)
                // Não esqueça o ".class" na Activity destino!
                Intent intent = new Intent(getApplicationContext(), ListaGruposActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
