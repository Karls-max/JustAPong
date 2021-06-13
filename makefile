args = `arg="$(filter-out $@,$(MAKECMDGOALS))" && echo $${arg:-${1}}`

all: sourceList
	javac -d bin @sourceList
	java -cp .:bin/ $(call args, Main)

sourceList:
	find -name "*.java" > sourceList

jar:
	cd ./bin && jar cfm $(call args, myPackage).jar manifest.txt $(call args, myPackage)*
	cd ./bin && java -jar $(call args, myPackage).jar


clean:
	find . -type f -name "*.class" -delete
	find . -type f -name "*.jar" -delete
	rm -f sourceList

%:
	@:
