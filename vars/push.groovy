def call(String project, String tag, String credentialsId ){
  withCredentials([usernamePassword(credentialsId: ${credentialsId}, passwordVariable: 'passwd', usernameVariable: 'username')]) {
  sh "docker login -u ${username} -p ${passwd}"
  sh "docker tag ${project}:${tag} $username/${project}:${tag}"
  sh "docker push ${username}/${project}:${tag}"
}
}
