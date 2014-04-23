all: Tour.class SmallestInsertion.class NearestInsertion.class

Tour.class: Tour.java
	javac -cp .:stdlib.jar Tour.java

SmallestInsertion.class: SmallestInsertion.java Tour.class
	javac -cp .:stdlib.jar SmallestInsertion.java

NearestInsertion.class: NearestInsertion.java Tour.class
	javac -cp .:stdlib.jar NearestInsertion.java

clean:
	rm -f *~
	rm -f *.class

run:
	java -cp .:stdlib.jar SmallestInsertion < tsp1000.txt
