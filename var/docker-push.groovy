def call(string project, string tag, string credentialsId ){
  withCredentials([usernamePassword(credentialsId: 'DockerhubCred', passwordVariable: 'passwd', usernameVariable: 'username')]) {
  sh 'docker login -u $username -p $passwd'
  sh 'docker tag $project:$tag $username/$project:$tag'
  sh 'docker push $username/$project:latest'
}
