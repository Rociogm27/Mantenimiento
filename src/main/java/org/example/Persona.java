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
        if(name.equals("") || name == null){
            throw new RuntimeException("Error: nombre de persona no valido");
        }
        this.name = name;
        if(age<0){
            throw new RuntimeException("Error: nombre de persona no valido");
        }
        this.age = age;
        if(!gender.equals("Male") && !gender.equals("Female")){
            throw new RuntimeException("Error: nombre de persona no valido");
        }
        this.gender=gender;
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

    public static double[] averageAgePerGender(List<Persona> persons){
        double[] devolver = new double[2];
        double hombre=0;
        double mujer=0;
        double sumaHombres=0;
        double sumaMujeres =0;
        for(Persona p:persons){
            if(p.gender.equals("Male")){
                sumaHombres += p.age;
                hombre++;
            }else{
                sumaMujeres += p.age;
                mujer++;
            }
        }
        if(hombre>0){
            devolver[0] = sumaHombres/hombre;
        }else{
            devolver[0] = 0;
        }

        if(mujer>0){
            devolver[1] = sumaMujeres/mujer;
        }else{
            devolver[1] = 0;
        }
        return  devolver;
    }
}
