default:
	javac -d out src/Fundamentals/*.java
	javac -d out -cp out src/FileStuff/*.java
	javac -d out -cp out src/GUI/*.java
