package school.cesar.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import school.cesar.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs: SharedPreferences = getSharedPreferences("none",Context.MODE_PRIVATE)
        val editor = prefs.edit()

        binding.btnEscrever.setOnClickListener {
            editor.apply {
                putString("name", binding.etName.text.toString())
                putString("age", binding.etIdade.text.toString())
                apply()
            }
        }

        binding.btnLer.setOnClickListener {
            binding.tvResult.text = "${prefs.getString("name", "Placeholder")}, sua idade é ${prefs.getString("age", "84")}"
        }

    }
}