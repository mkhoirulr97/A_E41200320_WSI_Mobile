package com.rafli.si_boss;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginActivityTest {

    //Tidak dapat melanjutkan jika username belum diisi
    @Test
    public void tanpa_username() {
        LoginActivity loga = new LoginActivity();
        loga.login("", "123");

        assertEquals(false, loga.isDestroyed());
    }

    //Tidak dapat melanjutkan jika password belum diisi
    @Test
    public void tanpa_password() {
        LoginActivity loga = new LoginActivity();
        loga.login("Rin", "");

        assertEquals(false, loga.isDestroyed());
    }

    //Dapat melanjutkan jika password & username diisi
    @Test
    public void username_password_terisi() {
        LoginActivity loga = new LoginActivity();
        loga.login("Rin", "123");

        assertEquals(true, loga.isDestroyed());
    }
}