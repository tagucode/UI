package jp.techacademy.satoshi.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            textView.text = editText.text.toString()
        } else if (v.id == R.id.button2) {
            showAlertDialog()
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
}

