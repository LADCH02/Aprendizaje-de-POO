/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymmanager3;

/**
 *
 * @author FCFM
 */
public class Ejercicio {
    private String nombre;
    private String grupo_muscular;
    private int series;
    private int repeticiones;
    private double pesoKg;
    private int rpe;
    
    
    public Ejercicio(String nombre, String grupo_muscular, int series, int repeticiones, double pesokg, int rpe){
        setNombre(nombre);
        this.grupo_muscular = grupo_muscular;
        this.series = series;
        this.repeticiones = repeticiones;
        setPesoKg(pesoKg);
        this.rpe = rpe;
    }
    
    public Ejercicio(String nombre, String grupo_muscular){
        setNombre(nombre);
        this.grupo_muscular = grupo_muscular;
        this.series = 3;
        this.repeticiones = 10;
        setPesoKg(1.0);
        this.rpe = 0;
    }
    
    
    public Ejercicio(){
        setNombre("Ejercicio generico");
        this.grupo_muscular = "Cuerpo completo";
    }
    
    
    public void setNombre(String nombre){
        if(nombre != null && nombre.trim().length() >= 3)
            this.nombre = nombre;
        else
            System.out.println("El nombre es muy corto no es valido " + nombre);
    }
    
    
    public void setPesoKg(double pesoKg){
        if(pesoKg > 0 && pesoKg < 300)
            this.pesoKg = pesoKg;
        else
            System.out.println("El peso seleccionado no es valido: " + pesoKg);
    }
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public double getPesoKg(){
        return this.pesoKg;
    }
    
    
    
    
    // 1) progreso de peso, 2) fallo muscular o cerca del fallo muscular, 3) Cambiar rep y ser, 4) obtener resumen , 5) obtener el nombre;
    
    
    public void progreso_peso(double pesoextra){
        pesoKg += pesoextra;
        System.out.println("En el ejercicio: " + nombre + "se obtuvo un nuevo peso de " + pesoKg);
    }
    
    public void fallo_muscular(int rpe){
        if(rpe > 8)
            System.out.println("En el ejercicio: " + nombre + " se encuentra apunto del fallo muscular con un RPE de " + rpe + "tenga cuidado puede tener una sobre carga nerviosa");
        else
            System.out.println("En el ejercicio: " + nombre + " se encuentra en un RPE optimo de " + rpe + " sin problema de tener una sobre carga");      
    }
    
    public void cambiar_parametros(int rpe, int series){
        this.rpe = rpe;
        this.series = series;
    }
    
    public String resumen(){
        return ("El grupo muscular es " + grupo_muscular + "\nEjercicio: " + nombre + "\nSeries: " + series + "\nRepeticiones: " + repeticiones + "\nEl peso maximo fue: " + pesoKg + "\nEl maximo RPE: " + rpe + "\nMuchas felicidades por su esfuerzo son unos maravillosos pesos los obtenidos vamos por mas");
    }
    
    @Override
    public String toString(){
        return String.format("Ejercicio: %s | Musculo: %s | Carga: %.2fkg (%dx%d)",nombre,grupo_muscular,pesoKg,series,repeticiones);
    }
}
