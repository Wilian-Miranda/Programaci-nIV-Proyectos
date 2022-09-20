package com.example.internasyanidadascalculadora

class MiclaseAnidadayInterna (){
    //parametros de la clase
    private val num: Int = 1;
    private fun retornarUno():Int{
        return num;
    }
    //clase anidada es una clase que puede estar dentro de otra clase
    class MiClaseAnidada (){
        fun suma(a:Int, b:Int):Int{
            return a + b;
        }
    }
    //inner permite acceder a la clase padre y a sus variables
    inner class MiClaseInterna(){

        fun restar(a:Int):Int{
            return a + num+retornarUno();
        }
    }
}