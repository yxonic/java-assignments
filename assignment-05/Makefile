all: LFSR.class PhotoMagic.class

LFSR.class: LFSR.java
	javac LFSR.java

PhotoMagic.class: LFSR.class PhotoMagic.java
	javac PhotoMagic.java

clean:
	rm -f *.class
	rm -f *~
