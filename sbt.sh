java -Xmx2048M -Xss1024M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m -jar `dirname $0`/sbt-launch-0.12.3.jar "$@"
