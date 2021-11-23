package com.ardianhilmip.retrovolley.retrofit.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ardianhilmip.retrovolley.R;
import com.ardianhilmip.retrovolley.retrofit.API.APIRequestData;
import com.ardianhilmip.retrovolley.retrofit.API.RetroServer;
import com.ardianhilmip.retrovolley.retrofit.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    private EditText etNama, etJabatan, etNoTelp, etAlamat, etEmail, etPassword;
    private String nama, jabatan, noTelp, alamat, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etNama = findViewById(R.id.etNama);
        etJabatan = findViewById(R.id.etJabatan);
        etNoTelp = findViewById(R.id.etNoTelp);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void actionDaftar(View view) {
        nama = etNama.getText().toString();
        jabatan = etJabatan.getText().toString();
        noTelp = etNoTelp.getText().toString();
        alamat = etAlamat.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        if (nama.trim().equals("")) {
            etNama.setError("Wajib diisi!");
        } else if (jabatan.trim().equals("")){
            etJabatan.setError("Wajib diisi!");
        } else if (noTelp.trim().equals("")) {
            etNoTelp.setError("Wajib diisi!");
        } else if (alamat.trim().equals("")) {
            etAlamat.setError("Wajib diisi!");
        } else if (email.trim().equals("")) {
            etEmail.setError("Wajib diisi!");
        } else if (password.trim().equals("")) {
            etPassword.setError("Wajib upload!");
        } else {
            simpanData();
        }
    }

    private void simpanData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class); // menghubungkan class interface ke retrofit
        Call<ResponseModel> simpanData = ardData.ardCreateData(nama, jabatan, noTelp, alamat, email, password);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(CreateActivity.this, "Kode: " +kode +" | Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(CreateActivity.this, "Gagal daftar: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
