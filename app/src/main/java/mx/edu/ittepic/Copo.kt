package mx.edu.ittepic

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Copo(l:Lienzo) {
    var l = l
    var x = 0f
    var y = 0f
    var tam = 0f

    init{
        x = (Math.random()*2000).toFloat()
        y = ((Math.random()*2500)*-1).toFloat()
        tam = ((Math.random()*10)+5).toFloat()
    }
    fun moverCopo(){
        y += tam
        if(y>1000) y= ((Math.random()*2500)*-1).toFloat()
    }
    fun pintarCopo(c: Canvas){
        val p = Paint()
        p.color = Color.rgb(245,225,206)
        c.drawCircle(x,y,tam,p)
    }

}