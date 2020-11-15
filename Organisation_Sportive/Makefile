all : doc genTest classes gen_jar_exec

doc :
	javadoc -d doc src/main/* src/utils/*

gen_jar_exec : classes
	jar cvfm Executable.jar META-INF/MANIFEST.MF -C ./out/ .

classes : 
	javac -d out -sourcepath src src/main/Application.java

genTest : classes
        javac -d out -cp lib/*:src src/test/CompetitionTest.java
        javac -d out -cp lib/*:src src/test/MockCompetition.java
        javac -d out -cp lib/junit-jupiter-api-5.4.2.jar:lib/*:src src/test/CompetitorTest.java
        javac -d out -cp lib/junit-jupiter-api-5.4.2.jar:lib/*:src src/test/LeagueTest.java
        javac -d out -cp lib/junit-jupiter-api-5.4.2.jar:lib/*:src src/test/ApplicationTest.java

clean :
	rm -rf Executable.jar doc out

