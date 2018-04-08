
#include <stdio.h>
#include <string.h>
#include <iostream>     
#include <fstream>      
#include "scanner.h"

int main()
{
    char archivo[] = {"foo.txt"};
	leer_archivo(&archivo[0]);
    return 0;
}

void leer_archivo(char *archivo_nombre){
	std::ifstream archivo(archivo_nombre,  std::ios_base::in);

    if (archivo.is_open()){
        char* buffer = new char[1024];
        while (archivo.read(buffer, 1024))
        {
            std::string linea_buffer(buffer);
            std::cout<< linea_buffer << std::endl;
        }

       std::string linea_buffer(buffer, archivo.gcount()); //agrega al string el resto de caracteres que quedan en el buffer
       std::cout<< linea_buffer << std::endl;

       delete[] buffer;
       archivo.close();
   }else{
        std::cout<< "No se puso abrir el archivo:" << archivo_nombre << std::endl;
   }
}