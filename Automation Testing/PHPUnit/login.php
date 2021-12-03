<?php

class Login{
    public function LoginSystem($email,$pass)
    {
        $emaill="mkhoirulr97@gmail.com";
        $passs ="123";
        if(filter_var($email, FILTER_VALIDATE_EMAIL)){
            if($email == $emaill && $pass == $passs){
                return true;
            }else{
                return false;
            }
        }
    }
}

?>