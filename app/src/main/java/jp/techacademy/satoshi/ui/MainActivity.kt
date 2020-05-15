package jp.techacademy.satoshi.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> textView.text = editText.text.toString()
            R.id.button2 -> showAlertDialog()
            R.id.button3 -> showTimePickerDialog()
            R.id.button4 -> showDatePickerDialog()
        }
    }

    private fun showAlertDialog(){
        // AlertDigalog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogbuilder = AlertDialog.Builder(this)
        alertDialogbuilder.setTitle("タイトル")
        alertDialogbuilder.setMessage("メッセージ")

        //肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogbuilder.setPositiveButton("肯定"){digalog, which ->
            Log.d("UI_PARTS", "肯定ボタン")
        }

        //中立ボタンに表示される文字列、押したときのリスナーを設定する
        //使わない引数の場合は「_」と記述するのがkotlinの練習
        alertDialogbuilder.setNeutralButton("中立"){_,_ ->
            Log.d("UI_PARTS", "中立ボタン")
        }

        //否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogbuilder.setNegativeButton("否定"){_,_ ->
            Log.d("UI_PARTS","否定ボタン")

        }

        //AlertDialogを作成して表示する
        val alertDialog = alertDialogbuilder.create()
        alertDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view , hour ,minute ->
                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }

    private fun showDatePickerDialog(){
        val showDatePickerDialog = DatePickerDialog (
                this,
                DatePickerDialog.OnDateSetListener() { view, year, month, dayofMonth ->
                        Log.d("UI_PARTS", "$year/${month + 1}/$dayofMonth")
                    },
          2020,
        4,
        1)
        showDatePickerDialog.show()
    }

}

