/*
 * GTablaFollows.java
 *
 * 2018/04/30 18:15:24
 *
 * Archivo generado por GikGram 2.0
 *
 * Copyright © Olminsky 2011 Derechos reservados
 * Reproducción sin fines de lucro permitida
 */

package Gramatica;

/**
 * Esta clase contiene la tabla de follows
 * y los métodos necesarios para acceder a ella
 */
abstract class GTablaFollows
{
	/**
	 * Tabla de follows
	 * Contiene los números de los terminales
	 * de los follows de cada no-terminal (filas)
	 */
	private static final int[][] TablaFollows =
	{
		/* <S> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <bloqueConstantes> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <nuevaConstante> */ {Gramatica.MARCA_DERECHA,20,19,16,8,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <asignarConstate> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializarConjuntoConst> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,76,75,4,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializarArregloCons> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializarCamposCons> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <bloqueTipos> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <nuevoTipo> */ {Gramatica.MARCA_DERECHA,20,19,16,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <asignarTipo> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <bloqueVariable> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <nuevaVariable> */ {Gramatica.MARCA_DERECHA,20,19,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <asignarVariable> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializacionConjunto> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorConjunto> */ {Gramatica.MARCA_DERECHA,28,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <agregarID> */ {Gramatica.MARCA_DERECHA,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializacionVariable> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <crearDimensionalidad> */ {Gramatica.MARCA_DERECHA,21,22,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <agregarDemension> */ {Gramatica.MARCA_DERECHA,21,22,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializacionArreglo> */ {Gramatica.MARCA_DERECHA,21,22,23,24,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <crearArreglo> */ {Gramatica.MARCA_DERECHA,32,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <agregarNivel> */ {Gramatica.MARCA_DERECHA,32,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <agrandarNivel> */ {Gramatica.MARCA_DERECHA,32,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorArreglo> */ {Gramatica.MARCA_DERECHA,32,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <crearRegistros> */ {Gramatica.MARCA_DERECHA,4,10,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <crearCampo> */ {Gramatica.MARCA_DERECHA,13,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <asignarCampo> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicializarCampos> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorCampo> */ {Gramatica.MARCA_DERECHA,15,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <bloquePrototipos> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <nuevoPrototipo> */ {Gramatica.MARCA_DERECHA,20,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <bloqueRutinas> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <nuevaRutina> */ {Gramatica.MARCA_DERECHA,20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <definicionFuncion> */ {Gramatica.MARCA_DERECHA,52,53,20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <definicionProcedimiento> */ {Gramatica.MARCA_DERECHA,52,53,20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <parametrosFormales> */ {Gramatica.MARCA_DERECHA,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <parametrosReales> */ {Gramatica.MARCA_DERECHA,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <agregarParametrosReales> */ {Gramatica.MARCA_DERECHA,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <inicioPrograma> */ {Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instrucciones> */ {Gramatica.MARCA_DERECHA,56,30,29,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccion> */ {Gramatica.MARCA_DERECHA,1,57,55,26,72,90,91,93,107,85,86,87,88,56,30,29,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionWHILE> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <bloqueInstrucciones> */ {Gramatica.MARCA_DERECHA,92,4,1,57,55,26,72,90,91,93,107,85,86,87,88,56,30,29,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionIF> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorCondicional> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorCondicionalSek> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorCondicionalVos> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionFor> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <InstruccionWith> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionRepeat> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionHalt> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionesSencillas> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <asignacionFamilia> */ {Gramatica.MARCA_DERECHA,31,27,14,45,46,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <sistemaAsignacion> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorQueAsigna> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <sistemaAsignacionVariables> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionAcceso> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <accesoString> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <accesoRegistro> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <accesoArreglos> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <masDimension> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <SizeOF> */ {Gramatica.MARCA_DERECHA,17,1,60,61,59,62,67,68,69,70,27,77,78,79,80,105,81,89,47,48,49,50,51,106,-1,-1,-1},
		/* <operacionesStr> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <tipoOperacionStr> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionesStringVarias> */ {Gramatica.MARCA_DERECHA,49,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <literalesOperacionString> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <literalesOperacionStringChar> */ {Gramatica.MARCA_DERECHA,66,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionesChar> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionChar> */ {Gramatica.MARCA_DERECHA,48,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionConjunto> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionesConjuntos> */ {Gramatica.MARCA_DERECHA,27,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <literalesConjuntosVar> */ {Gramatica.MARCA_DERECHA,76,75,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionesConjuntosVar> */ {Gramatica.MARCA_DERECHA,27,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionesConjuntosChar> */ {Gramatica.MARCA_DERECHA,27,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionLogica> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionesLogicas> */ {Gramatica.MARCA_DERECHA,105,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operadorLogico> */ {Gramatica.MARCA_DERECHA,105,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <expresion> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <expresionID> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <addExpresionMulDivCom> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <addExpresioSumRes> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <addExpresionCondicional> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <addExpresionLogicaD> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <addExpresionLogica> */ {Gramatica.MARCA_DERECHA,58,18,73,74,65,63,64,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <OperacionComparacion> */ {Gramatica.MARCA_DERECHA,45,46,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <OperacionCondicionalLogica> */ {Gramatica.MARCA_DERECHA,45,46,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <OperacionCondicional> */ {Gramatica.MARCA_DERECHA,45,46,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <sumRest> */ {Gramatica.MARCA_DERECHA,45,46,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <mulDivCom> */ {Gramatica.MARCA_DERECHA,45,46,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <operacionUnitaria> */ {Gramatica.MARCA_DERECHA,17,1,60,61,59,62,67,68,69,70,27,77,78,79,80,105,81,89,47,48,49,50,51,106,-1,-1,-1},
		/* <IncreDecremento> */ {Gramatica.MARCA_DERECHA,17,1,60,61,59,62,67,68,69,70,27,77,78,79,80,105,81,89,47,48,49,50,51,106,-1,-1,-1},
		/* <tipo> */ {Gramatica.MARCA_DERECHA,10,4,110,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,52,53,20,47,48,49,50,51,65},
		/* <tipoCompleto> */ {Gramatica.MARCA_DERECHA,4,47,48,49,50,51,65,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,52,53,20,-1,-1},
		/* <VALOR> */ {Gramatica.MARCA_DERECHA,5,15,47,48,49,50,51,4,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,32,28,-1,-1},
		/* <literalBoleana> */ {Gramatica.MARCA_DERECHA,5,15,47,48,49,50,51,4,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,32,28,-1,-1},
		/* <valorRetorno> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <manejoSalida> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <manejoEntrada> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <cohersionTipos> */ {Gramatica.MARCA_DERECHA,44,42,43,40,41,95,96,97,98,99,100,102,104,82,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <instruccionSwitch> */ {Gramatica.MARCA_DERECHA,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <casos> */ {Gramatica.MARCA_DERECHA,109,56,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/* <valorDefault> */ {Gramatica.MARCA_DERECHA,56,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
	};

	/**
	 * Método getTablaFollows
			Obtiene el número de terminal del follow del no-terminal
	 * @param numNoTerminal
			Número de no-terminal
	 * @param numColumna
			Número de columna
	 */
	static final int getTablaFollows(int numNoTerminal, int numColumna)
	{
		return TablaFollows[numNoTerminal][numColumna];
	}
}
