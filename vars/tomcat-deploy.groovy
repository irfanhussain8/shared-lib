def call(credId,TomcatIp,TomcatuserId){
sshagent(['credId']){
    // copy war file to tomcat server
    sh """
    scp -o StrictHostKeyChecking=no target/myweb*.war $(TomcatuserId)@$(TomcatIp):/opt/tomcat8/webapps/myweb.war
    ssh $(TomcatuserId)@$(TomcatIp) /opt/tomcat8/bin/shutdown.sh
    ssh $(TomcatuserId)@$(TomcatIp) /opt/tomcat8/bin/startup.sh
       """
  }
}
