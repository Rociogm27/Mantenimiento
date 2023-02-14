package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//prueba del branch
//esto es del develop
class PersonaTest {
 @Test
    public void PruebaMediaCorrecta(){

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

 @Test
 public void EdadNegativa(){
  //comprobamos que da error al poner edad inferior a 0
  assertThrows(RuntimeException.class,()->new Persona("Roberto", -3, "Male"));
 }

 @Test
 public void SexoErroneo(){
  //comprobamos que nos dice Male o Female para indicar el sexo y no otro atributo
  assertThrows(RuntimeException.class,()->new Persona("Raul", 18, "Macho"));
 }

 @Test
   public void NoHombresMediaCero(){
    //comprobamos que si no hay ningun hombre la media sea 0
    Persona pers1 = new Persona("Laura",40, "Female");
    Persona pers2 = new Persona("Monica",13, "Female");

    List<Persona> grupo = new ArrayList<>();
    grupo.add(pers1);
    grupo.add(pers2);

   double [] media = pers1.averageAgePerGender(grupo);
  assertEquals(0 , media[0]); //esperado de hombres

   }

   @Test
   public void NoMujeresMediaCero(){
    //comprobamos que si no hay ningun hombre la media sea 0
    Persona pers1 = new Persona("Pablo",40, "Male");
    Persona pers2 = new Persona("Jorge",13, "Male");

    List<Persona> grupo = new ArrayList<>();
    grupo.add(pers1);
    grupo.add(pers2);

    double [] media = pers1.averageAgePerGender(grupo);
    assertEquals(0 , media[1]); //esperado de hombres

   }

   @Test
   public void EdadReturnCorrecto(){
  //comprueba que el return pasa realmente el valor correcto
    Persona pers1 = new Persona("Pablo",40, "Male");

    int ValorTomado = pers1.age();
    int ValorEsperado = 40;
    assertEquals(ValorTomado,ValorEsperado);
   }

   @Test
   public void NombreReturnCorrecto(){
    //comprueba que el return pasa realmente el valor correcto
    Persona pers1 = new Persona("Pablo",40, "Male");

    String ValorTomado = pers1.name();
    String ValorEsperado = "Pablo";
    assertEquals(ValorTomado,ValorEsperado);
   }

   @Test
   public void SexoReturnCorrecto(){
    //comprueba que el return pasa realmente el valor correcto
    Persona pers1 = new Persona("Pablo",40, "Male");

    String ValorTomado = pers1.gender();
    String ValorEsperado = "Male";
    assertEquals(ValorTomado,ValorEsperado);
   }
}