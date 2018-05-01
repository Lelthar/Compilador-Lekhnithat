/*
 * Gramatica.h
 *
 * 2018/04/30 18:15:24
 *
 * Archivo generado por GikGram 2.0
 *
 * Copyright © Olminsky 2011 Derechos reservados
 * Reproducción sin fines de lucro permitida
 */
#pragma once

#ifndef INC_Gramatica_h_
	#define INC_Gramatica_h_

	/* Constantes necesarias para un driver de parsing */
	#define TERMINAL(X)  ((0 <= (X)) && ((X) <= 111))
	#define NO_TERMINAL(X)  ((112 <= (X)) && ((X) <= 213))
	#define MARCA_DERECHA 111
	#define NO_TERMINAL_INICIAL 112
	#define MAX_LADO_DER 10

	/* Constantes con las rutinas semánticas */
	/* NO SE DETECTARON SÍMBOLOS SEMÁNTICOS EN LA GRAMÁTICA */

	/* Prototipos de las tablas */
	extern const int TablaParsing[102][NO_TERMINAL_INICIAL];
	extern const int LadosDerechos[219][MAX_LADO_DER];

#endif /* INC_Gramatica_h_ */
