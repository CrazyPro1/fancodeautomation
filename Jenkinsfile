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
                // Run tests using Maven
                sh 'mvn test'
            }
        }
        stage('Run Tests') {
            steps {
                // Ensure the test-output directory exists
                sh '''
                    if [ ! -d "test-output" ]; then
                        mkdir -p test-output
                    fi
                '''
                // Run your test command and redirect output to a report file
                sh 'your-test-command > test-output/report.txt'  // Replace with the actual command
            }
        }
        stage('Report') {
            steps {
                // Publish the Extent Report after tests
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: 'test-output',
                    reportFiles: 'index.html',
                    keepAll: true
                ])
            }
        }
    }
}
