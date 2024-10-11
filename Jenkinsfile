pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git url: 'https://github.com/CrazyPro1/fancodeautomation.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                // Run Maven clean install to build the project
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run tests using Maven and redirect output to a report file
                sh '''
                    mkdir -p test-output  # Ensure the directory exists
                    mvn -e test > test-output/report.txt 2>&1  # Run tests and capture both stdout and stderr
                '''
            }
        }
        stage('Report') {
            steps {
                script {
                    // Check if the report file exists before attempting to publish
                    if (fileExists('test-output/index.html')) {
                        publishHTML(target: [
                            reportName: 'Extent Report',
                            reportDir: 'test-output',
                            reportFiles: 'index.html',
                            keepAll: true
                        ])
                    } else {
                        echo 'Report file index.html not found. Skipping report publishing.'
                    }
                }
            }
        }
    }
}
