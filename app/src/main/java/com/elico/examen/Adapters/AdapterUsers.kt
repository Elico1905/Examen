package com.elico.examen.Adapters

import android.content.Context
import android.text.TextUtils.substring
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elico.examen.MainActivity
import com.elico.examen.Modelos.ModelPrestamos
import com.elico.examen.R
import kotlinx.android.synthetic.main.item_recyclerview.view.*
import java.math.RoundingMode

class AdapterUsers(private val context: Context): RecyclerView.Adapter<AdapterUsers.ViewHolderAdapterUsers>() {

    private var datalist = mutableListOf<ModelPrestamos>()

    fun setListData(data: MutableList<ModelPrestamos>) {
        datalist = data
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUsers.ViewHolderAdapterUsers{
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false)
        return ViewHolderAdapterUsers(view)
    }

    override fun onBindViewHolder(holder: AdapterUsers.ViewHolderAdapterUsers, position: Int) {
        val Objeto = datalist[position]
        holder.bindView(Objeto)
    }

    inner class ViewHolderAdapterUsers(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(Objeto: ModelPrestamos) {
            itemView.item_cliente.text = "Cliente: ${Objeto.cliente}"
            itemView.item_monto.text = "Monto: ${Objeto.monto}"
            if (context is MainActivity){

                var plazo:String = context.GetDirefenciaFecha(Objeto.fecha,"15/02/2021")
                itemView.item_plazo.text = "Plazo: ${plazo}"

                var tasa:Double = 0.0

                if (plazo.toString().toInt() == 1){
                    tasa = 7.0
                }

                if (plazo.toString().toInt() in 2..7){
                    tasa = 6.50
                }

                if (plazo.toString().toInt() in 8..15){
                    tasa = 6.00
                }

                if (plazo.toString().toInt() in 16..30){
                    tasa = 5.50
                }

                if (plazo.toString().toInt() in 31..360){
                    tasa = 5.0
                }

                itemView.item_tasa.text = "Tasa de interes: ${tasa}"


                var interes:Double = Objeto.monto * plazo.toInt() * tasa * 360
                var newinteres:String = ""
                var contador:Int = 0
                var activo:Boolean = false
                var tam:Int = 0

                for (i in 0..interes.toString().length){
                    interes.toString().toCharArray(i)
                    if (interes.toString().toCharArray(i).equals(".")){
                        newinteres = newinteres + interes.toString().toCharArray(i).toString()
                            activo = true
                    }else{
                        newinteres = newinteres + interes.toString().toCharArray(i)
                    }

                    if (activo){
                        contador++
                    }
                    if (contador==2){
                        break
                    }
                    tam++
                }

//                newinteres = interes.toString().substring(0,tam)



                itemView.item_interes.text = "Interes: ${newinteres}"

                var iva:Double = interes * 16

                itemView.item_iva.text = "Iva: ${iva.toString()}"

                var pago:Double = Objeto.monto + interes + iva


                itemView.item_pago.text = "Pago: ${pago}"

            }


        }


    }

}