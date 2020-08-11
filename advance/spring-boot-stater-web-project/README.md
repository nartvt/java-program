# fix error can't not install oracle jdbc
at the pom location

mvn install:install-file -Dfile="path to file"/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar

