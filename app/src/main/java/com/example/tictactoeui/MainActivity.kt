package com.example.tictactoeui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.coroutines.delay
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    var option= 0
    var plays=0
    var matchon=true

    lateinit var btnclick: Button

    lateinit var box1 : CardView
    lateinit var box2 : CardView
    lateinit var box3 : CardView
    lateinit var box4 : CardView
    lateinit var box5 : CardView
    lateinit var box6 : CardView
    lateinit var box7 : CardView
    lateinit var box8 : CardView
    lateinit var box9 : CardView

    lateinit var img1: ImageView
    lateinit var img2: ImageView
    lateinit var img3: ImageView
    lateinit var img4: ImageView
    lateinit var img5: ImageView
    lateinit var img6: ImageView
    lateinit var img7: ImageView
    lateinit var img8: ImageView
    lateinit var img9: ImageView

    lateinit var counterTxt : TextView
    lateinit var playersturn : TextView

    var c1="empty"
    var c2="empty"
    var c3="empty"
    var c4="empty"
    var c5="empty"
    var c6="empty"
    var c7="empty"
    var c8="empty"
    var c9="empty"

    var v1=0
    var v2=0
    var v3=0
    var v4=0
    var v5=0
    var v6=0
    var v7=0
    var v8=0
    var v9=0


    private lateinit var counterTextView: TextView
    private var counter = 0
    private var handler: Handler = Handler()
    private lateinit var runnable: Runnable




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        playersturn=findViewById(R.id.playersturn)


        box1 = findViewById(R.id.box1)
        box2 = findViewById(R.id.box2)
        box3 = findViewById(R.id.box3)
        box4 = findViewById(R.id.box4)
        box5 = findViewById(R.id.box5)
        box6 = findViewById(R.id.box6)
        box7 = findViewById(R.id.box7)
        box8 = findViewById(R.id.box8)
        box9 = findViewById(R.id.box9)

        img1= findViewById(R.id.img1)
        img2= findViewById(R.id.img2)
        img3= findViewById(R.id.img3)
        img4= findViewById(R.id.img4)
        img5= findViewById(R.id.img5)
        img6= findViewById(R.id.img6)
        img7= findViewById(R.id.img7)
        img8= findViewById(R.id.img8)
        img9= findViewById(R.id.img9)

        counterTxt=findViewById(R.id.counter)




        box1.setOnClickListener{

            if(c1=="empty") {
                if (option == 0) {
                    img1.setImageResource(R.drawable.x)
                    option = 1
                    v1=1
                } else {
                    img1.setImageResource(R.drawable.o)
                    option = 0
                    v1=2
                }
                c1="filled"
                checkWin()
            }
        }

        box2.setOnClickListener{

            if(c2=="empty") {
                if (option == 0) {
                    img2.setImageResource(R.drawable.x)
                    option = 1
                    v2=1
                } else {
                    img2.setImageResource(R.drawable.o)
                    option = 0
                    v2=2
                }
                c2="filled"
                checkWin()
            }
        }
        box3.setOnClickListener{

            if(c3=="empty") {
                if (option == 0) {
                    img3.setImageResource(R.drawable.x)
                    option = 1
                    v3=1
                } else {
                    img3.setImageResource(R.drawable.o)
                    option = 0
                    v3=2
                }
                c3="filled"
                checkWin()
            }
        }
        box4.setOnClickListener{

            if(c4=="empty") {
                if (option == 0) {
                    img4.setImageResource(R.drawable.x)
                    option = 1
                    v4=1
                } else {
                    img4.setImageResource(R.drawable.o)
                    option = 0
                    v4=2
                }
                c4="filled"
                checkWin()
            }
        }
        box5.setOnClickListener{

            if(c5=="empty") {
                if (option == 0) {
                    img5.setImageResource(R.drawable.x)
                    option = 1
                    v5=1
                } else {
                    img5.setImageResource(R.drawable.o)
                    option = 0
                    v5=2
                }
                c5="filled"
                checkWin()
            }
        }

        box6.setOnClickListener{

            if(c6=="empty") {
                if (option == 0) {
                    img6.setImageResource(R.drawable.x)
                    option = 1
                    v6=1
                } else {
                    img6.setImageResource(R.drawable.o)
                    option = 0
                    v6=2
                }
                c6="filled"
                checkWin()
            }
        }

        box7.setOnClickListener{

            if(c7=="empty") {
                if (option == 0) {
                    img7.setImageResource(R.drawable.x)
                    option = 1
                    v7=1
                } else {
                    img7.setImageResource(R.drawable.o)
                    option = 0
                    v7=2
                }
                c7="filled"
                checkWin()
            }
        }

        box8.setOnClickListener{

            if(c8=="empty") {
                if (option == 0) {
                    img8.setImageResource(R.drawable.x)
                    option = 1
                    v8=1
                } else {
                    img8.setImageResource(R.drawable.o)
                    option = 0
                    v8=2
                }
                c8="filled"
                checkWin()
            }
        }
        box9.setOnClickListener{

            if(c9=="empty") {
                if (option == 0) {
                    img9.setImageResource(R.drawable.x)
                    option = 1
                    v9=1
                } else {
                    img9.setImageResource(R.drawable.o)
                    option = 0
                    v9=2
                }
                c9="filled"
                checkWin()
            }
        }

        startCounter()


    }

    private fun startCounter() {
        runnable = object : Runnable {
            override fun run() {
                counter++
                counterTxt.text = counter.toString()

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
    }

    private fun resetCounter() {
        counter = 0
        counterTxt.text = counter.toString()
        handler.removeCallbacks(runnable)
    }
    override fun onStop() {
        super.onStop()
        resetCounter()
    }


    fun checkWin() {
        var wins=0



        if (option == 1) {

            plays++

            if (((v1 == 1) && (v2 == 1) && (v3 == 1)) ||
                ((v4 == 1) && (v5 == 1) && (v6 == 1)) ||
                ((v7 == 1) && (v8 == 1) && (v9 == 1)) ||
                ((v1 == 1) && (v4 == 1) && (v7 == 1)) ||
                ((v2 == 1) && (v5 == 1) && (v8 == 1)) ||
                ((v3 == 1) && (v6 == 1 )&& (v9 == 1)) ||
                ((v1 == 1) && (v5 == 1) && (v9 == 1)) ||
                ((v7 == 1) &&( v5 == 1 )&&( v3 == 1)))
            {
                wins = 1
            }

            if(wins==1){
                playersturn.setText("player 1 Wins")
                setImgBlank()

            }
            else{
                playersturn.setText("player 2's Turn")

            }

        }

        else if(option==0) {

            plays++

            if (((v1 == 2) && (v2 == 2) && (v3 == 2)) ||
                ((v4 == 2) && (v5 == 2) && (v6 == 2)) ||
                ((v7 == 2) && (v8 == 2) && (v9 == 2)) ||
                ((v1 == 2) && (v4 == 2) && (v7 == 2)) ||
                ((v2 == 2) && (v5 == 2) && (v8 == 2)) ||
                ((v3 == 2) && (v6 == 2 )&& (v9 == 2)) ||
                ((v1 == 2) &&( v5 == 2) && (v9 == 2)) ||
                ((v7 == 2) && (v5 == 2) && (v3 == 2))
            )
            {
                wins=2

            }

            if(wins==2){
                playersturn.setText("player 2 Wins")
                setImgBlank()
            }
            else{
                playersturn.setText("Player 1's turn")
            }

        }


        if (plays==9 && wins==0) {
            playersturn.setText(" Match Tie")
            Handler().postDelayed({
                playersturn.setText("Player 1's turn ")
                setImgBlank()
            }, 2000)

        }

    }

    fun setImgBlank(){

        plays=0
        option=0


        img1.setImageResource(R.color.white)
        img2.setImageResource(R.color.white)
        img3.setImageResource(R.color.white)
        img4.setImageResource(R.color.white)
        img5.setImageResource(R.color.white)
        img6.setImageResource(R.color.white)
        img7.setImageResource(R.color.white)
        img8.setImageResource(R.color.white)
        img9.setImageResource(R.color.white)

        c1="empty"
        c2="empty"
        c3="empty"
        c4="empty"
        c5="empty"
        c6="empty"
        c7="empty"
        c8="empty"
        c9="empty"


        v1=0
        v2=0
        v3=0
        v4=0
        v5=0
        v6=0
        v7=0
        v8=0
        v9=0

        matchon=false

        resetCounter()
    }

}
