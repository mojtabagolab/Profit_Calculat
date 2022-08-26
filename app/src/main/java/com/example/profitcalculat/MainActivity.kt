package com.example.profitcalculat

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //مقدار اولیه برای محاسبه
        var result = 0

        //تابع کلیک دکمه
        button_calculate.setOnClickListener(View.OnClickListener {
            //برسی خالی نبودن ادیت تکست
            if (editTextNumber_price.text.length ==0) {
                DynamicToast.makeWarning(this, "لطفا یک عدد وارد کنید").show();
                return@OnClickListener
            }else {
                //گرقتن عدد از ادیت تکست
                val mablagh = editTextNumber_price.text.toString().toInt()
                //برسی ریدیو باتن انتخاب شده
                if (radioButton_profit10.isChecked) {
                    result = (mablagh * 10 / 100) *1
                    DynamicToast.make(this, result.toString(), R.mipmap.coin).show();
                }else if (radioButton_profit12.isChecked) {
                    result = (mablagh * 12 / 100 ) * 3
                    DynamicToast.make(this, result.toString(), R.mipmap.coin).show();
                }
                else {
                    DynamicToast.makeWarning(this, "لطفا یک گزینه را انتخاب کنید").show();
                }
            }
        })



    }
}
