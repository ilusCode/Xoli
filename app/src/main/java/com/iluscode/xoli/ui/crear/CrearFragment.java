package com.iluscode.xoli.ui.crear;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.iluscode.xoli.R;

import java.sql.SQLData;

import sql.sqlite;

public class CrearFragment extends Fragment {
    Button btnGuarda,btnLimpiar;
    String a,b,sex;
    EditText nombre,habitat,alimentacion,fechaIng,id;
    Spinner clase, tipo, sexo;
    public sqlite sqLite;

    private CrearViewModel crearViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        crearViewModel =
                ViewModelProviders.of(this).get(CrearViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crear, container, false);
        final TextView textView = root.findViewById(R.id.text_crear);
        crearViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //se establece la conexcion con los datos de lectura
        clase=root.findViewById(R.id.spClaficacion);
        tipo=root.findViewById(R.id.spEspecie);
        sexo=root.findViewById(R.id.spSexo);

        nombre=root.findViewById(R.id.inputNombre);
        habitat =root.findViewById(R.id.inputHabitat);
        alimentacion=root.findViewById(R.id.inputAlimentacion);
        fechaIng=root.findViewById(R.id.inputFechaIngreso);
        id=root.findViewById(R.id.inputId);

        btnGuarda=root.findViewById(R.id.btnGuardar);
        btnLimpiar=root.findViewById(R.id.btnLimpiar);

        sqLite=new sqlite(getContext());
        sqLite.abrirDB();
        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),
                R.array.opciones,
                android.R.layout.simple_spinner_item);

        clase.setAdapter(adapter);
        clase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return root;
    }
}