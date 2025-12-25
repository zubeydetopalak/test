pipeline {
    agent any

    stages {
        stage('Build & Test') {
            steps {
                script {
                    // Windows'tan Linux'a gelince dosya izni kaybolur, onu düzeltiyoruz
                    sh 'chmod +x mvnw'
                    // Linux olduğu için sh kullanıyoruz
                    sh './mvnw clean test'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy ediliyor...'
            }
        }
    }

    post {
        success {
            echo 'Başarılı'
        }
        failure {
            echo 'Başarısız'
        }
    }
}
