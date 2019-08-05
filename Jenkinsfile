node{
    stage('SCM Checkout'){
        checkout scm
    }
    stage('Test'){
        echo 'Testing...'
        dir('ServiciosCambioCat'){
            bat 'mvn clean test'
        }
    }
}
