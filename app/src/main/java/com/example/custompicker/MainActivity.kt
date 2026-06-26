package com.example.custompicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pick = Intent(
            Intent.ACTION_PICK
        ).apply {
            type = "image/*"
        }

        startActivityForResult(pick, 100)
    }


    override fun onActivityResult(
        requestCode:Int,
        resultCode:Int,
        data:Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        if(resultCode == RESULT_OK) {

            setResult(
                RESULT_OK,
                Intent().apply {
                    data = data?.data
                }
            )

        }

        finish()
    }
}