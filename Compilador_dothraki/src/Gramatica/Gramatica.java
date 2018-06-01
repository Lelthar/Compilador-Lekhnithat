/*
 * Gramatica.java
 *
 * 2018/06/01 03:34:05
 *
 * Archivo generado por GikGram 2.0
 *
 * Copyright © Olminsky 2011 Derechos reservados
 * Reproducción sin fines de lucro permitida
 */

package Gramatica;

/**
 * Esta clase contiene:
 * - Constantes necesarias para el driver de parsing
 * - Constantes con las rutinas semánticas
 * - Y los métodos necesarios para el driver de parsing
 */
public abstract class Gramatica
{
	/* Esta es la única clase que se accede fuera del paquete Gramatica */

	/**
	 * Constante que contiene el código de familia del terminal de fin de archivo
	 */
	public static final int MARCA_DERECHA = 111;

	/**
	 * Constante que contiene el número del no-terminal inicial
	 * (el primer no-terminal que aparece en la gramática)
	 */
	public static final int NO_TERMINAL_INICIAL = 112;

	/**
	 * Constante que contiene el número máximo de columnas que tiene los lados derechos
	 */
	public static final int MAX_LADO_DER = 10;

	/**
	 * Constante que contiene el número máximo de follows
	 */
	public static final int MAX_FOLLOWS = 46;

	/* Constantes con las rutinas semánticas */
	public static final int hake = 214;
	public static final int constanteID = 215;
	public static final int agregarConstante = 216;
	public static final int asignarValoresConstante1 = 217;
	public static final int agregarConjunto1 = 218;
	public static final int agregarConjunto2 = 219;
	public static final int agregarArreglo1 = 220;
	public static final int agregarArreglo2 = 221;
	public static final int agregarCampo1 = 222;
	public static final int agregarCampo2 = 223;
	public static final int agregarCampo3 = 224;
	public static final int crearTipoNombre = 225;
	public static final int agregarNuevoTipo = 226;
	public static final int asignarTipo1 = 227;
	public static final int asignarTipo2 = 228;
	public static final int asignarTipo3 = 229;
	public static final int asignarTipo4 = 230;
	public static final int asignarTipo5 = 231;
	public static final int nuevoVariableID1 = 232;
	public static final int asignarVariable1 = 233;
	public static final int creacionVariable1 = 234;
	public static final int asignarVariable2 = 235;
	public static final int creacionVariable2 = 236;
	public static final int asignarVariable3 = 237;
	public static final int creacionVariable3 = 238;
	public static final int asignarVariable4 = 239;
	public static final int creacionVariable4 = 240;
	public static final int inicializacionConjunto1 = 241;
	public static final int inicializacionConjunto2 = 242;
	public static final int agregarValoresConjunto1 = 243;
	public static final int agregarValoresConjunto2 = 244;
	public static final int agregarValoresConjunto3 = 245;
	public static final int nuevoVariableID2 = 246;
	public static final int inicializacionVariable1 = 247;
	public static final int crearDimensionalidad1 = 248;
	public static final int valorDimension1 = 249;
	public static final int crearDimensionalidad2 = 250;
	public static final int agregarDimension1 = 251;
	public static final int valorDimension2 = 252;
	public static final int agregarDimension2 = 253;
	public static final int inicializarArreglo1 = 254;
	public static final int inicializarArreglo2 = 255;
	public static final int agregarNivelArreglo1 = 256;
	public static final int agregarNivelArreglo2 = 257;
	public static final int agrandarNivelArreglo1 = 258;
	public static final int agregarValorArreglo1 = 259;
	public static final int agregarValorArreglo2 = 260;
	public static final int agregarValorArreglo3 = 261;
	public static final int agregarValorCampo1 = 262;
	public static final int agregarValorCampo2 = 263;
	public static final int accesoStrings1 = 264;
	public static final int accesoStrings2 = 265;
	public static final int accesoRegistros1 = 266;
	public static final int accesoRegistros2 = 267;
	public static final int inicializarExpresion = 268;
	public static final int finalizarExpresion1 = 269;
	public static final int agregarOperacion1 = 270;
	public static final int agregarOperacion2 = 271;
	public static final int agregarOperandos1 = 272;
	public static final int agregarOperandos2 = 273;
	public static final int agregarOperandos3 = 274;
	public static final int agregarOperandos4 = 275;
	public static final int agregarOperandos5 = 276;
	public static final int agregarOperandos6 = 277;
	public static final int agregarOperandos7 = 278;
	public static final int agregarOperandos8 = 279;
	public static final int agregarOperandos9 = 280;
	public static final int agregarParentesisIzqExp = 281;
	public static final int agregarParentesisDerExp = 282;
	public static final int finalizarExpresion2 = 283;
	public static final int agregarOperando1 = 284;
	public static final int agregarOperando2 = 285;
	public static final int agregarOperando3 = 286;
	public static final int agregarOperando4 = 287;
	public static final int agregarOperando5 = 288;
	public static final int agregarYath = 289;
	public static final int agregarZohhe = 290;

	/**
	 * Método esTerminal
			Devuelve true si el símbolo es un terminal
			o false de lo contrario
	 * @param numSimbolo
			Número de símbolo
	 */
	public static final boolean esTerminal(int numSimbolo)
	{
		return ((0 <= numSimbolo) && (numSimbolo <= 111));
	}

	/**
	 * Método esNoTerminal
			Devuelve true si el símbolo es un no-terminal
			o false de lo contrario
	 * @param numSimbolo
			Número de símbolo
	 */
	public static final boolean esNoTerminal(int numSimbolo)
	{
		return ((112 <= numSimbolo) && (numSimbolo <= 213));
	}

	/**
	 * Método esSimboloSemantico
			Devuelve true si el símbolo es un símbolo semántico
			(incluyendo los símbolos de generación de código)
			o false de lo contrario
	 * @param numSimbolo
			Número de símbolo
	 */
	public static final boolean esSimboloSemantico(int numSimbolo)
	{
		return ((214 <= numSimbolo) && (numSimbolo <= 290));
	}

	/**
	 * Método getTablaParsing
			Devuelve el número de regla contenida en la tabla de parsing
	 * @param numNoTerminal
			Número del no-terminal
	 * @param numTerminal
			Número del terminal
	 */
	public static final int getTablaParsing(int numNoTerminal, int numTerminal)
	{
		return GTablaParsing.getTablaParsing(numNoTerminal, numTerminal);
	}

	/**
	 * Método getLadosDerechos
			Obtiene un símbolo del lado derecho de la regla
	 * @param numRegla
			Número de regla
	 * @param numColumna
			Número de columna
	 */
	public static final int getLadosDerechos(int numRegla, int numColumna)
	{
		return GLadosDerechos.getLadosDerechos(numRegla, numColumna);
	}

	/**
	 * Método getNombresTerminales
			Obtiene el nombre del terminal
	 * @param numTerminal
			Número del terminal
	 */
	public static final String getNombresTerminales(int numTerminal)
	{
		return GNombresTerminales.getNombresTerminales(numTerminal);
	}

	/**
	 * Método getTablaFollows
			Obtiene el número de terminal del follow del no-terminal
	 * @param numNoTerminal
			Número de no-terminal
	 * @param numColumna
			Número de columna
	 */
	public static final int getTablaFollows(int numNoTerminal, int numColumna)
	{
		return GTablaFollows.getTablaFollows(numNoTerminal, numColumna);
	}
}
