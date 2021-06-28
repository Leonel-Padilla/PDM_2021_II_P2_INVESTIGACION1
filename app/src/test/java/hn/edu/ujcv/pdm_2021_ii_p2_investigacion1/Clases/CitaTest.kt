package hn.edu.ujcv.pdm_2021_ii_p2_investigacion1.Clases

import junit.framework.TestCase

class CitaTest : TestCase() {

    fun testComprobarPrecio(){
        val cita1 = Cita()
        cita1.numero        = 1
        cita1.descripcion   = "No hay descripcion"
        cita1.fecha         = "26/06/2021"
        cita1.precio        = 20.0

        val citas = hashMapOf<Int, Cita>()
        citas.put(cita1.numero, cita1)

        assertEquals("El precio de la cita numero 1 es = 15.0", cita1.comprobarPrecio(citas, cita1.numero))
    }//--
}//-----