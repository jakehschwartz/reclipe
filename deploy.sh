cp -fr source/* .

if [ ! -d "js" ]; then
	mkdir js
fi

# Generate .js files from Scala
sbt fastOptJS

cp target/scala-*/*.js js/