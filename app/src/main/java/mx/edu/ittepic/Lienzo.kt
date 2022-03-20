package mx.edu.ittepic

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo (este:MainActivity) : View(este) {
    var este = este
    val copo = Array<Copo>(50,{ Copo(this) })
    val alien = BitmapFactory.decodeResource(este.resources,R.drawable.ovni)
    var posXalien = 1800f
    var inOvn = 0
    val corutina = GlobalScope.launch{
        while (true){
            este.runOnUiThread{
                invalidate()
            }
            delay(50L)
        }
    }
    val moverOvni = object : CountDownTimer (2000,80){
        override fun onTick(p0: Long) {
            posXalien -= 5
            inOvn += 1
            if (posXalien<-500) posXalien = 2200f
            invalidate()
        }

        override fun onFinish() {
            start()
        }
    }

    init {
        moverOvni.start()
    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        //Pa' pintar Uaauauauaua
        var p = Paint()

        //fondo
        c.drawRGB(0,0,0)
//---------------------------------------------------------------COPOS QUE NO SON COPOS, SON "ESTRELLAS"
        (0..copo.size-1).forEach {
            copo[it].moverCopo()
            copo[it].pintarCopo(c)
        }
//------------------------------------------------------------------SOL
        //Sombra del sol
        p.color = Color.rgb(218,165,32)
        c.drawCircle(1700f,105f,160f,p)

        //Planeta
        p.color = Color.rgb(240,230,140)
        c.drawCircle(1700f,90f,150f,p)

        //Destellos
        p.color = Color.rgb(250,250,210)
        c.drawCircle(1710f,80f,80f,p)

//------------------------------------------------------------------MERCURIO

        //Detalles Oscuros
        p.color = Color.rgb(153,0,0)
        //p.color = Color.rgb(153,102,0)
        c.drawCircle(1500f,405f,68f,p)

        //Planeta
        p.color = Color.rgb(153,51,0)
        c.drawCircle(1500f,400f,65f,p)

        //Crateres
        p.color = Color.rgb(102,51,51)
        c.drawCircle(1460f,400f,15f,p)
        c.drawCircle(1480f,375f,18f,p)

        //Destello
        p.color = Color.rgb(250,250,210)
        c.drawCircle(1470f,430f,20f,p)
        c.drawCircle(1495f,395f,10f,p)

//------------------------------------------------------------------VENUS
        //Oscuro
        p.color = Color.rgb(153,102,0)
        c.drawCircle(1300f,550f,110f,p)

        //Planeta
        p.color = Color.rgb(204,153,0)
        c.drawCircle(1310f,540f,100f,p)

        //Claro
        p.color = Color.rgb(255,204,0)
        c.drawCircle(1325f,525f,60f,p)

        //Destello
        p.color = Color.rgb(250,250,210)
        c.drawCircle(1280f,575f,35f,p)

//------------------------------------------------------------------TIERRA
        //Oscuro agua
        p.color = Color.rgb(0,0,153)
        c.drawCircle(850f,680f,200f,p)

        //Planeta
        p.color = Color.rgb(0,51,255)
        c.drawCircle(870f,670f,180f,p)

        //Tierrita Fuerte
        p.color = Color.rgb(0,255,0)
        c.drawCircle(870f,670f,40f,p)
        c.drawCircle(940f,665f,60f,p)
        c.drawCircle(990f,650f,30f,p)
        c.drawCircle(770f,570f,20f,p)
        c.drawCircle(720f,700f,45f,p)
        c.drawCircle(750f,600f,30f,p)
        c.drawCircle(850f,780f,20f,p)
        c.drawCircle(920f,550f,10f,p)

        p.color = Color.rgb(0,155,0)
        c.drawCircle(940f,665f,40f,p)

        //Destello
        p.color = Color.rgb(250,250,210)
        c.drawCircle(770f,800f,40f,p)
        c.drawCircle(815f,760f,20f,p)
        c.drawCircle(950f,600f,30f,p)
//------------------------------------------------------------------MARTE
        //Oscuro
        p.color = Color.rgb(139,0,0)
        c.drawCircle(180f,800f,300f,p)

        //Planeta
        p.color = Color.rgb(205,92,92)
        c.drawCircle(220f,770f,250f,p)

        //Crateres
        p.color = Color.rgb(121,21,21)
        c.drawCircle(290f,770f,80f,p)
        c.drawCircle(400f,850f,40f,p)
        c.drawCircle(400f,730f,20f,p)

        p.color = Color.rgb(81,11,11)
        c.drawCircle(300f,760f,60f,p)
        c.drawCircle(420f,830f,25f,p)
        c.drawCircle(410f,720f,15f,p)

        c.drawBitmap(alien,posXalien,180f,p)
    }
}


