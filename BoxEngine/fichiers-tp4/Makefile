all : doc Date gen_DateTest gen_DateMain gen_jar gen_jar_exec

doc :
	javadoc date -cp src -d docs
Date :
	javac -d classes -cp classes -sourcepath src src/date/Date.java
gen_DateTest : Date
	javac -cp test-1.7.jar test/DateTest.java
gen_DateMain : 
	javac -d classes -cp classes -sourcepath src src/date/DateMain.java
gen_jar : DateMain
	cd classes/ ; jar cvf ../datemain.jar date ; cd ../
	mv datemain.jar tmp
gen_jar_exec : DateMain
	cd classes/ ; jar cvfm ../datemain.jar ../manifest-date date

DateTest : gen_DateTest Date
	java -jar test-1.7.jar DateTest
DateMain : gen_DateMain
	java -cp classes date.DateMain
jar : gen_jar DateMain
	java -cp tmp/datemain.jar date.DateMain
jar_exec : gen_jar_exec DateMain
	java -jar datemain.jar
