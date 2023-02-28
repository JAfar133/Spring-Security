package net.golovach.firstspringsecurityapp.util;


public class DontExistCityException extends Exception {

    public DontExistCityException(String msg){
        super(msg);
    }
}
