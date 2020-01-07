addCompilerPlugin("com.sksamuel.scapegoat" % "scalac-scapegoat-plugin_2.12.10" % "1.4.1")
scapegoatVersion in ThisBuild := "1.3.11"
scapegoatDisabledInspections := Seq(
  "AsInstanceOf",
)
scalacOptions ++= Seq(
  "-P:scapegoat:dataDir:./target/scapegoat"
) ++ scapegoatDisabledInspections.value.map(x => s"-P:scapegoat:disabledInspections:$x" )
