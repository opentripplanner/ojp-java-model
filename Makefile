release:
	git checkout main
	git pull
	mvn release:clean release:prepare release:perform -Dgoals=deploy release:clean

pr:
	xdg-open "https://github.com/opentripplanner/ojp-java-model/compare/main...`git rev-parse --abbrev-ref HEAD`"
