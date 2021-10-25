package com.example.dzikirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HarianDzikirDoaActivity : AppCompatActivity() {

    private val lisDzikirDoa: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikir_doa2)

        initData()

        val rvHarianDzikirDoaActivity = findViewById<RecyclerView>(R.id.rv_dzikir_doa_harian)
        rvHarianDzikirDoaActivity.layoutManager = LinearLayoutManager(this)
        rvHarianDzikirDoaActivity.adapter = DzikirDoaAdapter(lisDzikirDoa)
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.terjemah_dzikir_doa_harian)

        for (data in desc.indices) {
            val dzikir = DzikirDoa(
                desc[data],
                lafaz[data],
                terjemah[data]
            )
            lisDzikirDoa.add(dzikir)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}