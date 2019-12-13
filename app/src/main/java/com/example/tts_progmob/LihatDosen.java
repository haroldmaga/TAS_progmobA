package com.example.tts_progmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Toast;

import com.example.tts_progmob.Network.GetDataService;
import com.example.tts_progmob.R;
import com.example.tts_progmob.Adapter.DataDosenAdapter;
import com.example.tts_progmob.Model.DataDosen;
import com.example.tts_progmob.Adapter.DataKelasAdapter;
import com.example.tts_progmob.Network.GetDataService;
import com.example.tts_progmob.Network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class LihatDosen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataDosenAdapter dataDosenAdapter;
    private ArrayList<DataDosen> dataDosenArrayList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_dosen);

        addData();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService);
        Call<List<DataDosen>> call = service.getDosenAll("72160050");
        call.enqueue(new call.Callback<>() {
            @Override
            public void onResponse(Call<List<DataDosen>> call, Response<List<DataDosen>> response) {
                progressDialog.dismiss();


                recyclerView = findViewById(R.id.rvDosen);
                dataDosenAdapter = new DataDosenAdapter(response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatDosen.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dataDosenAdapter);
            }

            @Override
            public void onFailure(Call<List<DataDosen>> call1, Throwable t){
                progressDialog.dismiss();
                Toast.makeText(LihatDosen.this, "Login Gagal, Coba Lagi", Toast.LENGTH_SHORT);
            }



        });
    }
    private void addData() {
        dataDosenArrayList = new ArrayList<>();
        dataDosenArrayList.add(new DataDosen("72160050", "S.Kom", "Jl.kusuma negara", "haroldmaga16@gmail.com","ASA","Yosua Erick Gunawan",));
        dataDosenArrayList.add(new DataDosen("72160070-Setiawan", "S.Kom", "Jl.Seturan Raya", "setiawanel16@gmail.com","asa","ssa"));
    }
}
