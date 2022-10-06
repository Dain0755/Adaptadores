package com.example.adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] idImagen = {
              R.drawable.mila,
              R.drawable.ragnar,
              R.drawable.rocket,
              R.drawable.pepe,
              R.drawable.camila,
              R.drawable.andres,
              R.drawable.jorge,
        };
        String[] nombres = {
                "Mila", "Ragnar", "Rocket", "Pepe", "camila", "Andres", "Jorge"
        };
        String[] mensajes = {
                "Hola Daniel, bla bla bla", "Cuando vas a pagarme?", "Hablablo", "Oelo", "Mañana a las diez", "No trabajas hoy?", "Prestame la moto"
        };
        String[] horaUltimoMensaje ={
                "7:25", "10:15", "22:36", "11:55", "10:05", "21:20", "8:45"
        };
        String[] numeroTelefon ={
                "3058546977", "3156954872", "3056968162", "3156984756", "3056985463", "3115694873", "3204568971"
        };
        String[] pais = {
                "Noruega", "USA", "Nowhere", "Colombia", "Perú", "Colombia", "Colombia"
        };

        listAdapter listAdapter = new listAdapter(MainActivity.this, nombres, mensajes, horaUltimoMensaje, numeroTelefon,pais, idImagen);
        lista = (ListView) findViewById(R.id.listaView);
        lista.setAdapter(listAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent irAinformacion = new Intent(MainActivity.this, recibir.class)
                        .putExtra("nombre", nombres[position])
                        .putExtra("mensaje", mensajes[position])
                        .putExtra("hora", horaUltimoMensaje[position])
                        .putExtra("telefono", numeroTelefon[position])
                        .putExtra("pais", pais[position])
                        .putExtra("imagen", idImagen[position]);

                startActivity(irAinformacion);
            }
        });
    }
}