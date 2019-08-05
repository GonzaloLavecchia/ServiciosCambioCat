node{
    stage('SCM Checkout'){
        checkout scm
    }
    stage('Test'){
        echo 'Testing...'
        dir('Servicios'){
            bat 'mvn clean test'
        }
    }
}
