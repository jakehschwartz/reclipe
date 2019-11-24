if [ ! -d "docs" ]; then
	mkdir docs
fi

cp -fr source/* docs/

if [ ! -d "docs/js" ]; then
	mkdir docs/js
fi

# Generate .js files from Scala
sbt fastOptJS

cp target/scala-*/*.js docs/js/