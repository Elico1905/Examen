package com.elico.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesarferreira.tempo.Tempo
import com.cesarferreira.tempo.plus
import com.elico.examen.Adapters.AdapterUsers
import com.elico.examen.Modelos.ModelPrestamos
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterUsers
    private var lista = mutableListOf<ModelPrestamos>()
    private var data = mutableListOf<ModelPrestamos>()

    private val myTools = tools()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTools.CargarDatos()


        adapter = AdapterUsers(this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        lista = myTools.getdata()


        button.setOnClickListener {
            BuscarCliente(myTexview.text.toString())
        }

    }


    private fun BuscarCliente(Num_cliente:String){
        data.clear()

        for (i in 0 until lista.size){
            if (lista[i].cliente.equals(Num_cliente)){
                data.add(lista[i])
            }
        }

        adapter.setListData(data)
        adapter.notifyDataSetChanged()
    }


    fun GetDirefenciaFecha(fecha1:String,fecha2:String):String{
        val formato = SimpleDateFormat("dd/MM/yyyy")
        val date1: Date = formato.parse(fecha1)
        val date2: Date = formato.parse(fecha2)
        return getDiferencia(date1,date2).toString()
    }


    private fun getDiferencia(fechaInicial: Date, fechaFinal: Date): String? {
        var diferencia = fechaFinal.time - fechaInicial.time
        val segsMilli: Long = 1000
        val minsMilli = segsMilli * 60
        val horasMilli = minsMilli * 60
        val diasMilli = horasMilli * 24
        val diasTranscurridos = diferencia / diasMilli
        diferencia = diferencia % diasMilli
        val horasTranscurridos = diferencia / horasMilli
        diferencia = diferencia % horasMilli
        val minutosTranscurridos = diferencia / minsMilli
        diferencia = diferencia % minsMilli
        val segsTranscurridos = diferencia / segsMilli
//        return "diasTranscurridos: " + diasTranscurridos + " , horasTranscurridos: " + horasTranscurridos +
//                " , minutosTranscurridos: " + minutosTranscurridos + " , segsTranscurridos: " + segsTranscurridos

        return "${diasTranscurridos}"
    }

}