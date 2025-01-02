import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // İnternet bağlantısını kontrol et
        if (!NetworkUtils.isInternetAvailable(this)) {
            Toast.makeText(this, "İnternet bağlantısı yok! Uygulama kapatılıyor.", Toast.LENGTH_LONG).show()
            finish() // İnternet yoksa uygulamayı kapat
            return
        }
        
        // İnternet varsa devam et
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "İnternet bağlantısı mevcut, uygulama başlatıldı", Toast.LENGTH_SHORT).show()
        
        // Buradan sonra normal uygulama işlemlerine devam edebilirsiniz
    }
} 