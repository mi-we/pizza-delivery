
timestamps {
    node {

        stage("checkout") {
            checkout scm
        }

        stage("build software") {
            sh "./gradlew clean test"
        }

        stage("upload documentation") {
        }

        stage("wait for comparison") {
        }

        stage("verify comparison") {
        }
    }
}
