package gay.bielarusajed.shareasvxtwitter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

class ShareActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            handleSendText(intent)
        }
        finish()
    }

    private fun handleSendText(intent: Intent) {
        val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT) ?: return
        val modifiedText = processText(sharedText)
        
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, modifiedText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun processText(text: String): String {
        val urlRegex = "(https?://(?:[a-z0-9-]+\\.)?(?:twitter\\.com|x\\.com)/\\S+)".toRegex(RegexOption.IGNORE_CASE)
        
        return urlRegex.replace(text) { matchResult ->
            val originalUrl = matchResult.value
            try {
                val uri = Uri.parse(originalUrl)
                uri.buildUpon()
                    .authority("vxtwitter.com")
                    .clearQuery()
                    .build()
                    .toString()
            } catch (e: Exception) {
                originalUrl
            }
        }
    }
}
