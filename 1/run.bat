javac app\WEB-INF\classes\controller\Config.java 		-classpath ".\app\WEB-INF\classes;D:\glassfish5\glassfish\lib\javaee.jar; C:\Users\ahgin\Desktop\mySql_Drivers\mysql-connector-java-8.0.25.jar"
javac app\WEB-INF\classes\controller\Service.java 		-classpath ".\app\WEB-INF\classes;D:\glassfish5\glassfish\lib\javaee.jar; C:\Users\ahgin\Desktop\mySql_Drivers\mysql-connector-java-8.0.25.jar"

javac app\WEB-INF\classes\model\Model.java 			-classpath ".\app\WEB-INF\classes;D:\glassfish5\glassfish\lib\javaee.jar; C:\Users\ahgin\Desktop\mySql_Drivers\mysql-connector-java-8.0.25.jar"

cd app
start WinRAR A -r -f "app.war"
cd ..

TIMEOUT 3

copy /Y app\app.war D:\glassfish5\glassfish\domains\domain1\autodeploy\app.war

echo '################################################'






