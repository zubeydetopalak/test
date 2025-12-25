pipeline {
    agent any
  

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
