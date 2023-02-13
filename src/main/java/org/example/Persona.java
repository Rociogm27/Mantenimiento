package org.example;

import java.util.List;
/*
Class representing a person with a name, age and gender
@author Rocio Gomez
 */
public class Persona {
    private final String name;
    private final int age;

    private final String gender; //Male, Female

    public Persona(String name, int age, String gender){

        this.name = name;
        this.age = age;
        this.gender=gender;

        //comprobacion de que la edad es un numero positivo
        if(age<0){
            throw new RuntimeException("Error: Edad no valida");
        }

        //comprobacion de que los atributos dados son correctos de hombre y mujer

        if(!gender.equals("Male") && !gender.equals("Female")){
            throw new RuntimeException("Error: Sexo introducido incorrecto");
        }
        //comprobamos si el nombre esta null
        if(name.equals("") || name == null){
            throw new RuntimeException("Error: Nombre vacio");
        }

    }
    public String name(){
        return name;
    }
    public int age(){
        return age;
    }
    public String gender(){
        return gender;
    }

    public static double[] averageAgePerGender(List<Persona> personas){
        double[] duplaSol = new double[2];
        double hombre = 0;
        double mujer = 0;
        double sumHombres = 0;
        double sumMujeres = 0;

        for(Persona p:personas){
            if(p.gender.equals("Male")){
                sumHombres += p.age;
                hombre++;
            }else{
                sumMujeres += p.age;
                mujer++;
            }
        }
        if(hombre>0){
            duplaSol[0] = sumHombres/hombre;
        }else{
            duplaSol[0] = 0;
        }

        if(mujer>0){
            duplaSol[1] = sumMujeres/mujer;
        }else{
            duplaSol[1] = 0;
        }
        return  duplaSol;
    }
}
