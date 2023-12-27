package com.example.ecoreciclaproyecto;

//clase llamada user para que sea accesible desde otra clase
public class User {
    private String username;
    //accesible solo en esta clase, declarando atributo privado tipo string
    private String password;
    public User(String username, String password){
        this.username = username;
        this.password = password;
        //constructor de la clase, publico es llamado cuando se crea una nueva instancia
        //tiene dos parametros
    }
    //getter methods
    //se declara el metodo el cual devuelve el valor del atributo de la instancia
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}

