package com.example.es1toastwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Widget
    EditText etNome = null, etdDataNascita = null;
    CheckBox cbPatentato = null;
    RadioButton rbUomo = null, rbDonna = null;
    ListView lvElenco = null;

    // ArrayList per gli elementi inseriti
    final ArrayList<String> listPersone = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAggiungi = findViewById(R.id.btAdd);
        buttonAggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mostra_click();
            }
        });


        recuperaWidget();
    }

    private void recuperaWidget() {
        etNome = (EditText)findViewById(R.id.etNome);
        etdDataNascita = (EditText)findViewById(R.id.etdDataNascita);
        cbPatentato = (CheckBox) findViewById(R.id.cbPatentato);
        rbUomo = (RadioButton) findViewById(R.id.rbUomo);
        rbDonna = (RadioButton) findViewById(R.id.rbDonna);
        lvElenco = (ListView) findViewById(R.id.lvElenco);

    }

    public void Mostra_click()
    {
        String _nome = etNome.getText().toString();
        String _nascita = etdDataNascita.getText().toString();
        String _patente = "non patentato";
        if (cbPatentato.isChecked())
            _patente = "patentato";

        String _persona = "Nome: " + _nome + ", Nascita: " + _nascita + ", " + _patente;
        String _messaggio = "Inserito: "+ _nome;

        // Toast - Elemento che compare in sovraimpressione per breve tempo
        Toast toast = Toast.makeText(this,_messaggio, Toast.LENGTH_SHORT);
        toast.show();

        // ListView (final per renderlo non modificabile)
        listPersone.add(_persona);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1, listPersone); // il layout di simple_list_item_1 non è stato definito da nessuna parte esiste di default
        lvElenco.setAdapter(adapter);
    }
}