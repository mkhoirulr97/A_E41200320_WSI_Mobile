<?php
//menggunakan Framework PHPUnit
use PHPUnit\Framework\TestCase;

// Class yang akan di TEST.
require_once "login.php";

// Class untuk run Testing.
class test_login extends TestCase
{
    //membuat sebuah fungsi
    public function testLoginPost()
    {
        //class yang akan kita pakai
        $insert = new login();

        //memasukkan username dan password sesuai yang ada pada database
        $username = "mkhoirulr97@gmail.com";
        $password = "00000000";
        $hasil = $insert->login($username, $password);
        $this->assertTrue($hasil);
    }
}
