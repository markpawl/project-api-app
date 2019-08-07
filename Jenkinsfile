pipeline {
    agent none
    stages {
        stage('setup') {
            agent{
                docker { image 'maven:3.3.3' }
            }
            steps {
                sh 'mvn --version'
            }
        }
        stage('build') {
            agent{
                dockerfile true 
            }
            steps {
                sh 'java -version'
            }
        }        
    }
}