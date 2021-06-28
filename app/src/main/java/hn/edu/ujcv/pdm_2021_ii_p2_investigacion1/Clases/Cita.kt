package hn.edu.ujcv.pdm_2021_ii_p2_investigacion1.Clases

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class Cita(){
    var numero      = 0
    var descripcion = ""
    var fecha       = ""
    var precio      = 0.0

    fun comprobarPrecio(citas: HashMap<Int, Cita>, numeroDeCita: Int): String{
        var citaBuscada = citas[numeroDeCita]

        if (citaBuscada == null){
            return "Numero de cita no valido"
        }else{
            return "El precio de la cita numero $numeroDeCita es = ${citaBuscada.precio}"
        }
    }

    companion object{
    @JvmStatic
    fun verficicarCitas(citas: HashMap<Int, Cita>): HashMap<Int, Cita>{
        val citasHoy = hashMapOf<Int, Cita>()
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val fechaActual = sdf.format(Date()).toString()


        for (cita in citas){
            val citaActual = cita.value
            if (citaActual.fecha == fechaActual){
                citasHoy.put(cita.key, cita.value)
            }//-
        }//-
        return citasHoy
    }//--
    }

}//-----