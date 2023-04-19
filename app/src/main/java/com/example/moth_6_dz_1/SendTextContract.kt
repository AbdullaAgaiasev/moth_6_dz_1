package com.example.moth_6_dz_1

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.moth_6_dz_1.SendTextContract.Key.TEXT_KEY

class SendTextContract : ActivityResultContract<CharSequence?, CharSequence?>() {
    override fun createIntent(context: Context, input: CharSequence?): Intent {
        return Intent(context, TransitionActivity::class.java)
            .putExtra(TEXT_KEY, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CharSequence? {
        intent ?: return null
        if (resultCode != Activity.RESULT_OK) return null

        return intent.getCharSequenceExtra(TEXT_KEY)
    }
    object Key {
        const val TEXT_KEY = "text"
    }
}