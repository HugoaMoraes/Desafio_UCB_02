package com.example.app_do_hugo_desafio2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Switch
import android.widget.Button
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var meuRadioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val meuSwitch: Switch = findViewById(R.id.switch1);
        val meuBotao: Button = findViewById(R.id.button);
        val campoTextoNumber: TextView = findViewById(R.id.editTextNumber)
        val campoValor: TextView = findViewById(R.id.textView4)
        val textColor: TextView = findViewById(R.id.textView2)


        meuBotao.setOnClickListener{
            val valor: Double = campoTextoNumber.text.toString().toDouble();
            val botaoSelecionado: Int = meuRadioGroup.checkedRadioButtonId
            val arredondou: Boolean = meuSwitch.isChecked
            val porcentagem: Double = when (botaoSelecionado){
                R.id.radioButton2 -> 1.05
                R.id.radioButton3 -> 1.1
                R.id.radioButton4 -> 1.25
                else -> 1.0
            };
            val valorFinal: Double = porcentagem * valor;

            if (arredondou) {
                val scale = 2
                val valorArredondado : BigDecimal =  BigDecimal(valorFinal).setScale(scale, RoundingMode.UP)
                campoValor.setText("R$ ${valorArredondado}")
            }else{
                campoValor.setText("R$ ${valorFinal}")
            }
        }

    }
}