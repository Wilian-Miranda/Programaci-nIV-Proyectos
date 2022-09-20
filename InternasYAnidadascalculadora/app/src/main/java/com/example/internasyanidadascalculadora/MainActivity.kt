package com.example.internasyanidadascalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etDatoUno: EditText;
    lateinit var etDatoDos: EditText;
    lateinit var etResultado: EditText;

    lateinit var rbSumar: RadioButton;
    lateinit var rbRestar: RadioButton;
    lateinit var rbMultiplicar: RadioButton;
    lateinit var rbDividir: RadioButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //clasesAnidadasyInternas();
        etDatoUno  = findViewById(R.id.txtValorUno);
        etDatoDos = findViewById(R.id.txtValorDos);
        etResultado = findViewById(R.id.txtResultado);

        rbSumar = findViewById(R.id.rbSuma);
        rbRestar = findViewById(R.id.rbResta);
        rbMultiplicar = findViewById(R.id.rbMultiplicar);
        rbDividir = findViewById(R.id.rbDividir);
    }

    private fun clasesAnidadasyInternas(){
        //trabajando con clase anidada
        val miclaseAnidada = MiclaseAnidadayInterna.MiClaseAnidada();
        val sumarAB: Int = miclaseAnidada.suma(6,6);
        println("El resultado de la suma es: ${sumarAB}");

        //clase interna  (inner class)
        val claseInterna = MiclaseAnidadayInterna().MiClaseInterna();
        val restaAB = claseInterna.restar(7);
        println("El resultado de la resta es: ${restaAB}");
    }

    fun calcular(vista:View){
            val num1: Double = etDatoUno.text.toString().toDouble();
            val num2: Double = etDatoDos.text.toString().toDouble();

            if (rbSumar.isChecked){
                println("Estoy aqui");
                etResultado.setText(operar(num1,num2,"+").toString());
            }else if (rbRestar.isChecked){
                etResultado.setText(operar(num1,num2,"-").toString());
            }else if(rbMultiplicar.isChecked){
                etResultado.setText(operar(num1,num2,"*").toString());
            }else {
                etResultado.setText(operar(num1, num2, "/").toString());
            }

    }
    var resultado: Double = 0.0;
    private fun operar(a:Double,b:Double,tipo:String):Double{
        when(tipo){
            "+" ->{
                resultado = a + b;
            }
            "-" ->{
                resultado = a - b;
            }
            "*" ->{
                resultado = a * b;
            }
            else ->{
                if (b != 0.0){
                    resultado = a / b;
                }else{
                    Toast.makeText(this,"Error: No se puede dividir entre cero.", Toast.LENGTH_LONG).show();
                }
            }
        }
        return resultado;
    }



}