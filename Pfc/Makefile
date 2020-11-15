all : doc classes genTest genGameMain gen_jar gen_jar_exec

doc :
	javadoc pfc -cp src -d docs
classes : 
	mkdir classes
	javac -d classes -cp classes -sourcepath src src/pfc/Game.java
	javac -d classes -cp classes -sourcepath src src/pfc/strategy/PaperStrategy.java
	javac -d classes -cp classes -sourcepath src src/pfc/strategy/ScissorsStrategy.java
	javac -d classes -cp classes -sourcepath src src/pfc/strategy/ConstantStrategy.java
	javac -d classes -cp classes -sourcepath src src/pfc/strategy/RandomStrategy.java
genTest : classes
	javac -d classes -cp test-1.7.jar test/pfc/ShapeTest.java
	javac -d classes -cp test-1.7.jar test/pfc/PlayerTest.java
	javac -d classes -cp test-1.7.jar test/pfc/GameTest.java
gen_jar_exec : genGameMain
	cd classes/ ; jar cvfm ../gamemain.jar ../manifest-game pfc io
genGameMain : classes
	javac -d classes -cp classes -sourcepath src src/pfc/GameMain.java

ShapeTest : genTest classes
	java -jar test-1.7.jar pfc.ShapeTest
PlayerTest : genTest classes
	java -jar test-1.7.jar pfc.PlayerTest
GameTest : genTest classes
	java -jar test-1.7.jar pfc.GameTest

clean :
	rm -rf gamemain.jar docs classes
