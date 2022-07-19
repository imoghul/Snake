echo "Main-Class: Main" > manifest.txt
javac *.java
javac */*.java
jar cvfm CircuitSimulator.jar manifest.txt *.class */*.class
cp CircuitSimulator.jar ~/desktop/CircuitSimulator.jar
find . -name "*.class" -delete
rm manifest.txt
