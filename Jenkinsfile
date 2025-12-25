pipeline {
    agent any
    
    tools {
        // Jenkins'te tanımlı Maven ismini buraya yazın (Örn: 'M3' veya 'Maven 3.8')
        maven 'Maven 3.8' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Kodunuzu Git'ten çekme adımı (eğer varsa)
                // git 'https://github.com/kullanici/proje.git'
                echo 'Kodlar çekiliyor...'
            }
        }

        stage('Test') {
            steps {
                // Maven ile testleri çalıştır
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Test raporlarını JUnit formatında kaydet
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
