pipeline {
    agent any

    environment {
        IMAGE_NAME = 'playwright-java-framework'
        CONTAINER_NAME = 'playwright-container'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sunil-bombe/PlaywrightFrameworkWithJava.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $IMAGE_NAME ."
                }
            }
        }

        stage('Run Tests in Docker') {
            steps {
                script {
                    // Remove old container if exists
                    sh "docker rm -f $CONTAINER_NAME || true"

                    // Run container and mount local allure-results to host
                    sh """
                    docker run --name $CONTAINER_NAME \
                        -v "\$PWD/allure-results:/app/allure-results" \
                        $IMAGE_NAME
                    """
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                sh 'allure generate allure-results --clean -o allure-report'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'allure-report/**', fingerprint: true
        }
    }
}
