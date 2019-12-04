default:	src/Fundamentals/*.java
	javac -d out/JoJo src/Fundamentals/*.java

loaders:
	javac -d out/LoadSave -cp $(CLASSPATH):src/Fundamentals/JoJo.java src/Fundamentals/Stand.java
	javac -d out/LoadSave -cp $(CLASSPATH):out/JoJo src/FileStuff/*.java

viewer:
	javac -d out/JoJoViewer src/Fundamentals/JoJo.java src/Fundamentals/Stand.java
	javac -d out/JoJoViewer -cp $(CLASSPATH):out/JoJo src/GUI/*.java
runViewer:
	java -cp $(CLASSPATH):out/JoJoViewer GUITest
