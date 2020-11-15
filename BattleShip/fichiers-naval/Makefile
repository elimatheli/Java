all : doc classes genTest genGameMain gen_jar gen_jar_exec

doc :
	javadoc battleship -cp src -d docs
classes :
	mkdir classes
	javac -d classes -cp classes -sourcepath src src/battleship/Game.java
genTest : classes
	javac -d classes -cp test-1.7.jar test/battleship/ShipTest.java
	javac -d classes -cp test-1.7.jar test/battleship/CellTest.java
	javac -d classes -cp test-1.7.jar test/battleship/SeaTest.java
genGameMain : classes
	javac -d classes -cp classes -sourcepath src src/battleship/GameMain.java
gen_jar : genGameMain
	cd classes/ ; jar cvf ../gamemain.jar battleship ; cd ../
	mv gamemain.jar tmp
gen_jar_exec : genGameMain
	cd classes/ ; jar cvfm ../gamemain.jar ../manifest-game battleship io


ShipTest : genTest classes
	java -jar test-1.7.jar battleship.ShipTest
CellTest : genTest classes
	java -jar test-1.7.jar battleship.CellTest
SeaTest : genTest classes
	java -jar test-1.7.jar battleship.SeaTest

GameMain : genGameMain
	java -cp classes battleship.GameMain

jar : gen_jar genGameMain
	java -cp tmp/gamemain.jar battleship.GameMain
jar_exec : gen_jar_exec genGameMain
	java -jar gamemain.jar
