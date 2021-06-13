args = `arg="$(filter-out $@,$(MAKECMDGOALS))" && echo $${arg:-${1}}`

all: .sourceList
	javac -d pong @.sourceList

run:
	java -cp .:pong/ $(call args, myPackage.Main)

jar: all
	cd ./pong && jar cfm $(call args, myPackage).jar manifest.txt $(call args, myPackage)*
	cd ./pong && java -jar $(call args, myPackage).jar

.sourceList:
	find -name "*.java" > .sourceList

clean:
	find . -type f -name "*.class" -delete
	find . -type f -name "*.jar" -delete
	rm -f .sourceList

%:
	@:
