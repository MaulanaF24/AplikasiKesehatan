package com.bootcamp.ujian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.bootcamp.ujian.model.Data;
import com.location.aravind.getlocation.GeoLocator;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    public static int ID_FORM_2=2222;
    String datax;

    EditText txtNama,txtUmur,txtDarah,txtAlamat,txtBeratBadan;
    Button btnAlamat,btnDarah,btnSimpan;
    Intent intent;
    GeoLocator geoLocator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_input_data);
        setTitle("Input Data Pasien");
        geoLocator = new GeoLocator(InputActivity.this,InputActivity.this);
        txtNama = findViewById(R.id.txtNama);
        txtUmur = findViewById(R.id.txtUmur);
        txtDarah = findViewById(R.id.txtDarah);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtBeratBadan = findViewById(R.id.txtBerat);

        btnDarah = findViewById(R.id.btnDarah);
        btnAlamat = findViewById(R.id.btnAlamat);
        btnSimpan = findViewById(R.id.btnSimpan);

        txtDarah.setEnabled(false);
        txtAlamat.setEnabled(false);

        btnAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(InputActivity.this,geoLocator.getLattitude() + "," + geoLocator.getLongitude() + "\n" + geoLocator.getAddress(),Toast.LENGTH_LONG).show();
              txtAlamat.setText(geoLocator.getAddress());
            }
        });

        btnDarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(InputActivity.this, BloodPressure.class);
                startActivityForResult(intent,InputActivity.ID_FORM_2);
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data = new Data();
                data.setNama(txtNama.getText().toString());
                data.setUmur(Integer.parseInt(txtUmur.getText().toString()));
                data.setBeratBadan(Integer.parseInt(txtBeratBadan.getText().toString()));
                data.setAlamat(txtAlamat.getText().toString());
                data.setTekananDarah(txtDarah.getText().toString());
                data.save();

                Intent pindah = new Intent(InputActivity.this,MainActivity.class);
                startActivity(pindah);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== InputActivity.ID_FORM_2 && resultCode == 4){
            setResult(4,data);
            if(data != null){
                datax = data.getStringExtra("Bpm");
                txtDarah.setText(datax);
            }
        }
    }
}
