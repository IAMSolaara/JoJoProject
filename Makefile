default:	src/Fundamentals/*.java
	javac -d out/JoJo src/Fundamentals/*.java

loaders:
	javac -d out/LoadSave -cp src/Fundamentals/JoJo.java src/Fundamentals/Stand.java
	javac -d out/LoadSave -cp out/JoJo src/FileStuff/*.java

viewer:
	javac -d out/JoJoViewer src/Fundamentals/JoJo.java src/Fundamentals/Stand.java
	javac -d out/JoJoViewer -cp out/JoJo src/GUI/*.java
