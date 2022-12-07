
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t yassine15/demo-app:spring-app-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push yassine15/demo-app:spring-app-1.0'
    }
}

def pushToNexus() {
    echo "pushing the jar file to Nexus maven-snapshots repo..."
    sh 'mvn clean install -Dmaven.test.skip=true'
nexusArtifactUploader artifacts: [[artifactId: 'devops', classifier: '', file: 'target/devops-0.0.1-SNAPSHOT.jar', type: 'jar']], credentialsId: 'nexus-credentials', groupId: 'org.springframework.boot', nexusUrl: '20.13.123.42:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '0.0.1-SNAPSHOT'
}

def sonarScan() {
        echo "Running sonarQube scan..."
        withSonarQubeEnv('sonarqube') {
           // sh "${scannerHome}/bin/sonar-scanner"
              sh "mvn clean verify sonar:sonar -Dsonar.projectKey=sonarqube -Dmaven.test.skip=true"
        }
       /* timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        } */
        
}

def deployApp() {
         def instance = "jenkins@20.23.253.136"
         def shellCmd = "docker-compose up build"

               sshagent([ credentials: 'deploy-credentials']) {
                    sh "scp -o StrictHostKeyChecking=no docker-compose.yml ${instance}:/home/jenkins"
                    sh "ssh -o StrictHostKeyChecking=no ${instance} ${shellCmd}"
 }
}

def cleanUntaggedImages(String serverIp, String serverUser){
    def cleanImages = 'docker image prune --force --filter "dangling=true"'
    sshagent (credentials: ['jenkins-server']) {
        sh "ssh -o StrictHostKeyChecking=no ${serverUser}@${serverIp} ${cleanImages}"
    }
}

return this
