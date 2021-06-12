all: sourceList
	javac -d bin @sourceList
	java -cp bin/ $(call args, Main)

sourceList:
	find -name "*.java" > sourceList

jar: manifest.txt
	 jar cfm $(call args, Main).jar manifest.txt bin/ *.*

clean:
	find . -type f -name "*.class" -delete
