package ar.edu.uade.model;

import ar.edu.uade.enums.ExigenciaMuscular;
import ar.edu.uade.enums.GrupoMuscular;
import ar.edu.uade.model.ejercicio.Ejercicio;
import ar.edu.uade.model.ejercicio.TotalEjercicios;

import java.util.List;

public class Entrenamiento {
	
	private List<Ejercicio> ejercicios;
	private double duracion;

	public Entrenamiento() {
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public Entrenamiento crearEntrenamiento(ExigenciaMuscular nivelExigencia, int nivelAerobicoMin, int nivelAerobicoMax){

		TotalEjercicios totalEjercicios = new TotalEjercicios();
		totalEjercicios.cargarEjercicios();

		//por cada grupo muscular agrega un ejercicio. el entrenamiento estará compuesto de 5 ejercicios
		for(GrupoMuscular musculo : GrupoMuscular.values()){
			for(int i =0; i<5; i++){
				Ejercicio ej = totalEjercicios.getTotalEjercicios().get(i);
				if(ej.getGrupoMuscular() == musculo){
					if (nivelExigencia == ej.getExigenciaMuscular()){
						if (ej.getNivelAerobico() >= nivelAerobicoMin && ej.getNivelAerobico() <= nivelAerobicoMax){
							this.ejercicios.add(ej);
						}
					}
				}
			}
		}
		return this;

	}
	//Para cada ejercicio del Entrenamiento se aumenta la carga un 5%
	public void reforzar(){
		for (Ejercicio e:ejercicios){
			e.setCarga(e.getCarga()*1.05);
		}
	}



}
