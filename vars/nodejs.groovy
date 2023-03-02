def call() {
    node {
        git branch: 'main', url: "https://github.com/madhaviaws/${COMPONENT}.git"
        env.APPTYPE="nodejs"
        env.ARGS="-Dsonar.sources=."
        common.lintCheck()
        common.sonarCheck()
        common.testCases()
        if (env.TAG_NAME != null) {
            common.artifact()
        }
    }
}

//  def lintCheck() {
//    sh ''' 
//      # We want Devs to handle the lint checks failure 
//    # npm i jslint 
//  # node_modules/jslint/bin/jslint.js  server.js || true 
//           echo Starting lint checks
//           echo Lint Checks Completed for ${COMPONENT}
//      ''' 
//  }


// def call() {
// pipeline {
//     agent any 
//      //environment {
//        // SONAR      = credentials('SONAR')
//        //NEXUS      = credentials('NEXUS')
//     //}
//       stages{
//         stage ('Downloading the Dependencies') {
//               steps{
//                  sh "npm install"
//                  sh "echo npm installation"
//                 }
//             }

//             stage ('Lint Checks'){
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
//                     script { 
//                         env.ARGS="-Dsonar.sources=."
//                       common.sonarCheck()
//                    }
//                 }
//             }
//             stage('Test Cases') {
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

//             //             stage('Check the release') {
// //                 when {
// //                     expression { env.TAG_NAME != null }   // Only runs when you run this against the TAG
// //                 }
// //                 steps {
// //                     script {
// //                         env.UPLOAD_STATUS=sh(returnStdout: true, script: 'curl -L -s http://172.31.8.205:8081/service/rest/repository/browse/${COMPONENT} | grep ${COMPONENT}-${TAG_NAME}.zip || true')
// //                         print UPLOAD_STATUS
// //                     }
// //                 }
// //             }
//             //stage('Prepare Artifacts') {
//               //  when {
//                 //    expression { env.TAG_NAME != null }   // Only runs when you run this against the TAG
//                   ////  expression { env.UPLOAD_STATUS == "" }
//                 //}
//                 //steps {
//                   //  sh  'echo preparing artifacts'
// //                         sh ''' 
// //                         npm install 
// //                         zip ${COMPONENT}-${TAG_NAME}.zip node_modules server.js

// //                     ''' 
//                 //}
//             //}

//             //stage('Upload Artifacts') {
//                 //when {
//                 //    expression { env.TAG_NAME != null }   // Only runs when you run this against the TAG
//               //      //expression { env.UPLOAD_STATUS == "" }
//             //    }
//           //      steps {
//         //            sh 'echo uploading artifacts'
//  //                   sh ''' 
// //                         curl -f -v -u ${NEXUS_USR}:${NEXUS_PSW} --upload-file ${COMPONENT}-${TAG_NAME}.zip http://172.31.8.205:8081/repository/${COMPONENT}/${COMPONENT}-${TAG_NAME}.zip
// //                     '''
//       //          }
//     //        }
//        }
    
// }
// }