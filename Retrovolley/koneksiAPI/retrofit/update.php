<?php

require("config.php");

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id = $_POST['id'];
    $nama = $_POST['nama'];
    $id_jabatan = $_POST['id_jabatan'];
    $no_telp = $_POST['no_telp'];
    $alamat = $_POST['alamat'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    
    $query_insert = "UPDATE akun SET nama = '$nama', id_jabatan = '$id_jabatan', no_telp = '$no_telp', alamat = '$alamat', email = '$email', password = '$password' WHERE id = '$id'";
    $result = mysqli_query($conn, $query_insert);
    $cek = mysqli_affected_rows($conn);

    if ($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Data Berhasil Diubah";
    } else {
        $response["kode"] = 0;
        $response["pesan"] = "Data Gagal Diubah";
    }
} else {
    $response["kode"] = 0;
    $response["pesan"] = "Tidak Ada Post Data";
}

echo json_encode($response);
mysqli_close($conn);

?>