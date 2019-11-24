if [ ! -d "public" ]; then
	mkdir public
fi

cp -fr source/* public/

if [ ! -d "public/js" ]; then
	mkdir public/js
fi

# Generate .js files from Scala
sbt fastOptJS

cp target/scala-*/*.js public/js/