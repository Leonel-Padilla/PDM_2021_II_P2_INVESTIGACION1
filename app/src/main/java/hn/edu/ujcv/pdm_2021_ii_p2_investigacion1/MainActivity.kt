package hn.edu.ujcv.pdm_2021_ii_p2_investigacion1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_ii_p2_investigacion1.Clases.Cita
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(){
    var citas = hashMapOf<Int, Cita>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGuardarCita.setOnClickListener{guardarCita()}
        btnRevisarCitas.setOnClickListener{revisarCitas()}
        txvFechaDeCita2.setOnClickListener{calendario()}
        btnConsultarPrecio.setOnClickListener{consultarPrecio()}

    }

    private fun consultarPrecio(){
        val cita1 = Cita()
        if (txtNumeroDeCita.text.isEmpty()){
            Toast.makeText(applicationContext, "El numero de cita etá vacio", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, cita1.comprobarPrecio(citas, txtNumeroDeCita.text.toString().toInt()), Toast.LENGTH_SHORT).show()
        }

    }


    fun calendario(){
        val c = Calendar.getInstance()
        val date = Date()

        var año = c.get(Calendar.YEAR)
        var mes = c.get(Calendar.MONTH)+1
        var dia = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, {view, Año, Mes, Dia -> txvFechaDeCita2.setText(""+Dia+"/"+Mes+"/"+Año)},año,mes,dia)
        dpd.show()
    }

    fun revisarCitas(){
        val citasHoy : HashMap<Int, Cita> = Cita.verficicarCitas(citas)
        var contador = 0

        for (cita in citasHoy){
            contador++
        }
        if (contador == 0){
            val toast = Toast.makeText(applicationContext, "No hay citas para el día de hoy", Toast.LENGTH_LONG).show()
        }else {
            val toast = Toast.makeText(applicationContext, "Tiene un total de $contador citas para hoy", Toast.LENGTH_SHORT).show()

            for (cita in citasHoy){
                val toast = Toast.makeText(applicationContext, "Cita numero: ${cita.value.numero} \n " +
                        "Descripcion: ${cita.value.descripcion} \n Fecha ${cita.value.fecha} \n Precio: ${cita.value.precio}", Toast.LENGTH_LONG).show()
            }
        }//-
    }//--

    fun guardarCita(){
        val cita1 = Cita()
        val citaDePrueba: Cita?

        if (txtNumeroDeCita.text.isEmpty()){
            val toast = Toast.makeText(applicationContext, "El numero de la cita está vacío", Toast.LENGTH_SHORT).show()
        }else{
            citaDePrueba = citas[txtNumeroDeCita.text.toString().toInt()]
            if(citaDePrueba != null){
                val toast = Toast.makeText(applicationContext, "Este numero de cita ya está registrado.", Toast.LENGTH_SHORT).show()
            }else if (txtDescripcion.text.isEmpty()){
                val toast = Toast.makeText(applicationContext, "La descripcion de la cita está vacía", Toast.LENGTH_SHORT).show()
            }else if (txvFechaDeCita2.text.isEmpty()){
                val toast = Toast.makeText(applicationContext, "La fecha de la cita está vacía", Toast.LENGTH_SHORT).show()
            }else if (txtPrecio.text.isEmpty()){
                val toast = Toast.makeText(applicationContext, "El precio de la cita está vacio", Toast.LENGTH_SHORT).show()
            }else{
                cita1.numero       = txtNumeroDeCita.text.toString().toInt()
                cita1.descripcion  = txtDescripcion.text.toString()
                cita1.fecha        = txvFechaDeCita2.text.toString()
                cita1.precio       = txtPrecio.text.toString().toDouble()

                citas.put(cita1.numero, cita1)
                val toast = Toast.makeText(applicationContext, "Cita guardada", Toast.LENGTH_SHORT).show()
            }
        }

    }//--
}