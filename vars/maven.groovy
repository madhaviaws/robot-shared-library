def call() {
    node {
        git branch: 'main', url: "https://github.com/madhaviaws/${COMPONENT}.git"
        env.APPTYPE="maven"
        common.sonarCheck()
        common.lintCheck()
        sh 'mvn clean compile'
        env.ARGS="-Dsonar.java.binaries=target/"
        common.testCases()
        if (env.TAG_NAME != null) {
            common.artifact()
        }
    }
}


// def lintCheck() {
//     sh ''' 
//          echo Starting lint checks ${COMPONENT}
//       #   mvn checkstyle:check || true                        # lint checks
//          echo Lint Checks Completed for ${COMPONENT}
       
//        ''' 
// }

// def call() {
// pipeline {
//     agent any 
//     // environment {
//       //  SONAR      = credentials('SONAR')
//     //}
//         stages{
            
//           stage ('Lint Checks'){
//                 steps {
//                      //script{
//                        // sample.info("Welcome","stockexchange.com
//                        // ")
//                      //}
//                      script{
//                         lintCheck()
//                      }
//                     //sh "echo installing jslint"
//                     //sh "npm i jslint"
//                     //sh "node_modules/jslint/bin/jslint.js server.js"
//                    // sh "echo lint checks has completed"
                    
//                 } 

//             }
//             stage('Sonar Check') {
//               steps {
//                 script { 
//                   //      mvn clean compile 
//                     //    env.ARGS="-Dsonar.projectKey=target/"
//                         common.sonarCheck()
//                     }
//                 }
//             }
//              stage('Test Cases') {
//             parallel {
//                 stage('Unit Tests') {
//                   steps {
//                     sh 'echo Unit Test Cases Completed'
//                          }
//                     }
//                 stage('Integration Tests') {
//                   steps {
//                     sh 'echo Integration Test Cases Completed'
//                    }
//                 }
//                 stage('Functional Tests') {
//                   steps {
//                     sh 'echo Functional Test Cases Completed'
//                    }
//                 }
//                }
//             }
//      }
    
// }
// }