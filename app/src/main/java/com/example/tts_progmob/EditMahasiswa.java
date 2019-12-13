package com.example.tts_progmob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMahasiswa extends AppCompatActivity {
    EditText nama, nidn, alamat, email, foto;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dosen);

        setTitle("Edit Data Dosen");

        nama = (EditText) findViewById(R.id.editNamaDsn);
        nidn = (EditText) findViewById(R.id.editNidnDsn);
        alamat = (EditText) findViewById(R.id.editAlamatDsn);
        email = (EditText) findViewById(R.id.editEmailDsn);
        foto = (EditText) findViewById(R.id.editFotoDsn);
        simpan = (Button) findViewById(R.id.simpanBtnEdit);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nama.getText().toString().length()==0){
                    nama.setError("silahkan mengisi Nama MHS");
                }else if (nidn.getText().toString().length()==0){
                    nidn.setError("silahkan mengisi NIDN MHS");
                }else if (alamat.getText().toString().length()==0){
                    nidn.setError("silahkan mengisi Alamat MHS");
                }else if (email.getText().toString().length()==0) {
                    email.setError("silahkan mengisi Email MHS");
                }else if (foto.getText().toString().length()==0){
                    foto.setError("silahkan mengisi Foto MHS");
                }else{
                    Toast.makeText(getApplicationContext(),"Berhasil Diubah",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}