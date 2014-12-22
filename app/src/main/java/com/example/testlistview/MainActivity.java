package com.example.testlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<Cliente> miCliente = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llenarListaCliente();
        llenarListView();
        registerClickCallback();

    }

    private void llenarListaCliente() {

        miCliente.add(new Cliente("Dulce Gutierrez Reyes", 1400, 2));
        miCliente.add(new Cliente("Jonathan Axel Nuñez", 1500, 3));
        miCliente.add(new Cliente("Monse Diaz Gonzales", 1600, 2));
        miCliente.add(new Cliente("Miguel Angel Garcia", 1700, 3));
        miCliente.add(new Cliente("Brenda Hernandez Garcia", 1800, 1));
        miCliente.add(new Cliente("Edy Cortes Perez", 1900, 2));
    }


    private void llenarListView() {
        ArrayAdapter<Cliente> adapter = new CustomClienteAdapter(getApplication(), miCliente);
        ListView listView = (ListView) findViewById(R.id.list_cliente);
        listView.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView listView = (ListView) findViewById(R.id.list_cliente);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente clicked = miCliente.get(position);

                String mensaje = "Apretaste: " + position
                                 + " nombre contacto: " + clicked.getNombreCliente();
                Toast.makeText(getApplication(), mensaje, Toast.LENGTH_LONG).show();
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
