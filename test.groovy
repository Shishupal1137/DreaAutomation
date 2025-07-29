pipeline {
    agent any

    stages {
        stage('Get Source Code') {
            steps {
                git branch: 'dev', url: 'https://github.com/Shishupal1137/DreaAutomation.git'
                echo 'Hello World'
            }
        }

        stage('Build Code') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn test -Dbrowser=localchrome'
            }
        }
    }

    post {
        success {
            emailext (
                to: 'rajabhaiya1137@gmail.com',
                subject: "✅ Build Passed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                Hello Raja Bhaiya,

                ✅ Your Jenkins build *${env.JOB_NAME}* ran successfully!

                🔢 Build Number: ${env.BUILD_NUMBER}
                🔗 View Details: ${env.BUILD_URL}

                Regards,  
                Jenkins CI
                """
            )
        }
    }
}
