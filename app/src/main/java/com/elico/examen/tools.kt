package com.elico.examen

import com.elico.examen.Modelos.ModelPrestamos

class tools {
    private var listaPrestamos = ArrayList<ModelPrestamos>()

    fun CargarDatos(){
        listaPrestamos.add(ModelPrestamos("00103228",1,"10/01/2021",37500.0,"Pendiente"))
        listaPrestamos.add(ModelPrestamos("00103228",2,"19/01/2021",725.18,"Pendiente"))
        listaPrestamos.add(ModelPrestamos("00103228",3,"31/01/2021",1578.22,"Pendiente"))
        listaPrestamos.add(ModelPrestamos("00103228",4,"04/02/2021",380.0,"Pendiente"))

        listaPrestamos.add(ModelPrestamos("70099925",1,"07/01/2021",2175.25,"Pagado"))
        listaPrestamos.add(ModelPrestamos("70099925",2,"13/01/2021",499.99,"Pagado"))
        listaPrestamos.add(ModelPrestamos("70099925",3,"24/01/2021",5725.18,"Pendiente"))
        listaPrestamos.add(ModelPrestamos("70099925",4,"07/02/2021",876.13,"Pendiente"))

        listaPrestamos.add(ModelPrestamos("00298185",1,"04/02/2021",545.55,"Pendiente"))
        listaPrestamos.add(ModelPrestamos("15000125",1,"31/12/2020",15220.0,"Pagado"))


    }

    fun getdata(): MutableList<ModelPrestamos> {
        return listaPrestamos
    }
}