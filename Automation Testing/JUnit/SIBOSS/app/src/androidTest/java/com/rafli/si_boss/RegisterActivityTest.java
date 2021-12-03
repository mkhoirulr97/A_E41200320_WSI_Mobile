package com.rafli.si_boss;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RegisterActivityTest {

    //Tidak dapat melanjutkan jika password kosong
    @Test
    public void password_kosong () {
        RegisterActivity re = new RegisterActivity();
        re.register("Rin", "", "Rian");

        assertEquals(false, re.isDestroyed());
    }

    //Tidak dapat melanjutkan jika username & name kosong
    @Test
    public void username_kosong () {
        RegisterActivity re = new RegisterActivity();
        re.register("", "123", "");

        assertEquals(false, re.isDestroyed());
    }

    //Dapat melanjutkan jika username & password terisi
    @Test
    public void username_password_terisi () {
        RegisterActivity re = new RegisterActivity();
        re.register("Rin", "123", "Rian");

        assertEquals(true, re.isDestroyed());
    }
}