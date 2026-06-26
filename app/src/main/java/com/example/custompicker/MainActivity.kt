package com.example.custompicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val picker = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            type = "*/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }

        startActivityForResult(picker, 100)
    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {

            val result = Intent().apply {
                setData(data?.data)

                addFlags(
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            }

            setResult(
                RESULT_OK,
                result
            )
        }

        finish()
    }
}