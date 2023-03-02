def call() {
    node {
        git branch: 'main', url: "https://github.com/madhaviaws/${COMPONENT}.git"
        env.APPTYPE="go"
        common.lintCheck()
        env.ARGS="-Dsonar.sources=."
        common.sonarCheck()
        common.testCases()
        if (env.TAG_NAME != null) {
            common.artifact()
        }
    }
}