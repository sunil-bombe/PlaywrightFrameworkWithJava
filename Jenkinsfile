pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo/playwright-java-framework.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Report') {
            steps {
                sh 'allure generate allure-results --clean -o allure-report'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'allure-report/**', fingerprint: true
        }
    }
}
