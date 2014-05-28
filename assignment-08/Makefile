DIR=org/yxonic/snake

all: $(DIR)/Snake.class

$(DIR)/Snake.class: $(DIR)/Play.java $(DIR)/Snake.java $(DIR)/Board.java $(DIR)/Maps.java
	javac $(DIR)/Play.java

run: all
	java org.yxonic.snake.Play

clean:
	rm -f $(DIR)/*.class
	rm -f $(DIR)/*~
