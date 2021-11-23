package com.ardianhilmip.retrovolley.retrofit.activity;

import android.content.Intent;
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

public class UpdateActivity extends AppCompatActivity {

    private EditText etNama, etJabatan, etNoTelp, etAlamat, etEmail, etPassword;
    private int id;
    private String nama, jabatan, noTelp, alamat, email, password, getNama, getJabatan, getNoTelp, getAlamat, getEmail, getPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent terimaData = getIntent(); // menerima data dari adapter data
        id = terimaData.getIntExtra("id", -1); // jika yg diterima id yg salah, karena -1 tidak ada
        nama = terimaData.getStringExtra("nama");
        jabatan = terimaData.getStringExtra("id_jabatan");
        noTelp = terimaData.getStringExtra("noTelp");
        alamat = terimaData.getStringExtra("alamat");
        email = terimaData.getStringExtra("email");
        password = terimaData.getStringExtra("password");

        etNama = findViewById(R.id.etNama);
        etJabatan = findViewById(R.id.etJabatan);
        etNoTelp = findViewById(R.id.etNoTelp);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        etNama.setText(nama);
        etJabatan.setText(jabatan);
        etNoTelp.setText(noTelp);
        etAlamat.setText(alamat);
        etEmail.setText(email);
        etPassword.setText(password);
    }

    private void updateData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class); // menghubungkan class interface ke retrofit
        Call<ResponseModel> updateData = ardData.ardUpdateData(id, getNama, getJabatan, getNoTelp, getEmail, getAlamat, getPassword);

        updateData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(UpdateActivity.this, "Kode: " +kode +" | Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Gagal daftar: " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void actionPerbarui(View view) {
        // mengirim data yang berasal dari inputan
        getNama = etNama.getText().toString();
        getJabatan = etJabatan.getText().toString();
        getNoTelp = etNoTelp.getText().toString();
        getEmail = etEmail.getText().toString();
        getAlamat = etAlamat.getText().toString();
        getPassword = etPassword.getText().toString();

        updateData();
    }
}
