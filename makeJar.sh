echo "Main-Class: Main" > manifest.txt
javac *.java
javac */*.java
jar cvfm Snake.jar manifest.txt *.class */*.class
cp Snake.jar ~/desktop/Snake.jar
find . -name "*.class" -delete
rm manifest.txt
