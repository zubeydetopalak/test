import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WebsiteAccessTest {

    @Test
    public void testWebsiteAccessPermission() {
        String hedefUrl = "https://example.com";

        // 1. İstemci oluştur (10 saniye zaman aşımı ile)
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // 2. İstek oluştur
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(hedefUrl))
                .GET()
                .build();

        try {
            // 3. İsteği gönder
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            // 4. Jenkins için Assertion (Doğrulama)
            // Eğer statusCode 200 değilse test başarısız olur ve mesajı gösterir.
            Assertions.assertEquals(200, statusCode,
                    "❌ Test Başarısız! Beklenen: 200, Gelen: " + statusCode + ". Erişim izni yok veya site hatası.");

            // Eğer buraya gelindiyse test geçmiştir
            System.out.println("✅ Test Başarılı: " + hedefUrl + " erişimi mevcut.");

        } catch (IOException | InterruptedException e) {
            // Bağlantı hatası olursa testi doğrudan başarısız yap
            Assertions.fail("❌ Test Başarısız: Sunucuya bağlanılamadı. Hata: " + e.getMessage());
        }
    }
}