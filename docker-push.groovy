def call(string project, string tag, string credentialsId ){
  withCredentials([usernamePassword(credentialsId: 'DockerhubCred', passwordVariable: 'passwd', usernameVariable: 'username')]) {
  sh 'docker login -u $username -p $passwd'
  sh 'docker tag notes-app:latest $username/notes-app:latest'
  sh 'docker push $username/notes-app:latest'
}
