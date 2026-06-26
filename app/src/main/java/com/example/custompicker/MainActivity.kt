package com.example.custompicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pickIntent = Intent(Intent.ACTION_PICK).apply {
            type = "image/*"
        }

        startActivityForResult(pickIntent, 100)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        resultIntent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, resultIntent)

        if (requestCode == 100 && resultCode == RESULT_OK) {

            val selectedUri = resultIntent?.data

            val result = Intent().apply {
                data = selectedUri
            }

            setResult(
                RESULT_OK,
                result
            )

        }

        finish()
    }
}