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
}
