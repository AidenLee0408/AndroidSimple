package androidstudykotlin.part1.ch02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidstudykotlin.part1.ch02.databinding.ActivityMainBinding
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        val outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val inputEditText = binding.inputEditTextView
        val inputUnitTextView = binding.inputUnitTextView
        val swapImageButton = binding.swapImageButton

        var inputNumber : Int = 0
        var cmToM = true

        inputEditText.addTextChangedListener{ text ->
            inputNumber = if(text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
            }



            if (cmToM) {
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }


        }

        swapImageButton.setOnClickListener {
            cmToM = !cmToM
            if(cmToM) {
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            }else {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }


    }
}