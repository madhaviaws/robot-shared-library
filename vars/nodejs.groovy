def lintCheck() {
    sh ''' 
         # We want Devs to handle the lint checks failure 
         # npm i jslint 
         # node_modules/jslint/bin/jslint.js  server.js || true 
         echo Starting lint checks
         echo Lint Checks Completed for ${COMPONENT}
    ''' 
}

def call() {
pipeline {
    agent any 
        stages{
            stage ('Downloading the Dependencies') {
              steps{
                //sh "npm install"
                sh "npm installation"
                }
            }

            stage ('Lint Checks'){
                steps {
                    // script{
                      //  sample.info("Welcome","stockexchange.com
                        //")
                     //}
                     script{
                        lintCheck()
                     }
                    //sh "echo installing jslint"
                    //sh "npm i jslint"
                    //sh "node_modules/jslint/bin/jslint.js server.js"
                   // sh "echo lint checks has completed"
                    
                }      
            }
        }
    
}
}