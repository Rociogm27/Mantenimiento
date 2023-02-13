package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
 @Test
    public void PruebaMedia(){

     //creamos las personas con los atributos
     Persona pers1 = new Persona("Juan",15, "Male");
     Persona pers2 = new Persona("Laura",40, "Female");
     Persona pers3 = new Persona("Monica",13, "Female");
     Persona pers4 = new Persona("Roberto",15, "Male");

     //añadimos a todas las personas a un array
     List<Persona> grupo = new ArrayList<>();
     grupo.add(pers1);
     grupo.add(pers2);
     grupo.add(pers3);
     grupo.add(pers4);

     //primera pos media de hombres y segunda pos de mujeres
     double [] media = pers1.averageAgePerGender(grupo);

     assertEquals(15 , media[0]); //esperado de hombres
     assertEquals(26.5, media[1]); //esperado de mujeres


 }

 @Test
 public void NombreErroneo(){
 //ponemos una persona con nombre vacio y observamos si lanza la excepcion
  assertThrows(RuntimeException.class,()->new Persona("", 45, "Male"));

 }

}