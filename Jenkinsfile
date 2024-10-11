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
                    mkdir -p test-output  // Ensure the directory exists
                    mvn -X test > test-output/report.txt  // Run tests and generate report
                '''
            }
        }
        stage('Report') {
            steps {
                // Publish the Extent Report after tests
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: 'test-output',
                    reportFiles: 'index.html',  // Ensure this file exists after tests
                    keepAll: true
                ])
            }
        }
    }
}
