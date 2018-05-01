/*
 * GNombresTerminales.java
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
 * Esta clase contiene los nombres de los terminales
 * y los métodos necesarios para acceder a ella
 */
abstract class GNombresTerminales
{
	/**
	 * Contiene los nombres de los terminales
	 */
	private static final String[] NombresTerminales =
	{
		"Hake",
		"ID",
		"Evoon",
		"Kemat",
		".",
		",",
		"Veneser",
		"Vineserat",
		"Esinasolat",
		"Shim",
		":=",
		"Khalassar",
		"Marilat",
		"Hethkat",
		"<<",
		">>",
		"Khadokh",
		"(",
		")",
		"Khado",
		"Evolat",
		"Yorosor",
		"Lirikh",
		"Laqat",
		"Akat",
		"Yanqokh",
		"iste",
		"{",
		"}",
		"arrekSek",
		"arrekVos",
		"[",
		"]",
		"@",
		"->",
		"+=",
		"-=",
		"*=",
		"/=",
		"%=",
		"+",
		"-",
		"*",
		"%",
		"//",
		"yath",
		"zohhe",
		"literalEntero",
		"literalChar",
		"literalString",
		"sek",
		"vos",
		"assokh",
		"thikh",
		"esin",
		"evat",
		"nakho",
		"kash",
		"tat",
		"|><|",
		"|<",
		"|>",
		"|*",
		">|",
		"<|",
		":",
		"|",
		"<_>",
		"<^>",
		"<&>",
		"<#>",
		"athzhokwazar",
		"ha",
		"emralat",
		"akko",
		"%~",
		"%&",
		"%+",
		"%-",
		"%?",
		"%!",
		"vo",
		"ma",
		"che",
		"xche",
		"yarat",
		"sille",
		"irge",
		"charat",
		"asolat",
		"she",
		"save",
		"Arrekaan",
		"soro",
		"COMANDO",
		">",
		">=",
		"<",
		"<=",
		"=",
		"<>",
		"&",
		"&&",
		"or",
		"||",
		"expresion",
		"!",
		"verat",
		"gache",
		"nakhaan",
		"debug",
		" EOF "
	};

	/**
	 * Método getNombresTerminales
			Obtiene el nombre del terminal
	 * @param numTerminal
			Número del terminal
	 */
	static final String getNombresTerminales(int numTerminal)
	{
		return NombresTerminales[numTerminal];
	}
}
