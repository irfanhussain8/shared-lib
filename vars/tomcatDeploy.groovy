def call(credId,tomcatIp,tomcatuserId){
sshagent([credId]){
    // copy war file to tomcat server
    sh """
    scp -o StrictHostKeyChecking=no target/myweb*.war $(tomcatuserId)@$(tomcatIp):/opt/tomcat8/webapps/myweb.war
    ssh $(tomcatuserId)@$(tomcatIp) /opt/tomcat8/bin/shutdown.sh
    ssh $(tomcatuserId)@$(tomcatIp) /opt/tomcat8/bin/startup.sh
       """
  }
}
