args = `arg="$(filter-out $@,$(MAKECMDGOALS))" && echo $${arg:-${1}}`

all: sourceList.txt
	javac -d pong @sourceList.txt
	java -cp .:pong/ $(call args, Main)

sourceList.txt:
	find -name "*.java" > sourceList.txt

jar:
	cd ./pong && jar cfm $(call args, myPackage).jar manifest.txt $(call args, myPackage)*
	cd ./pong && java -jar $(call args, myPackage).jar


clean:
	find . -type f -name "*.class" -delete
	find . -type f -name "*.jar" -delete
	rm -f sourceList.txt

%:
	@:
