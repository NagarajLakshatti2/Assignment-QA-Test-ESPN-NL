# Assignment-QA-Test-ESPN-NL

mvn clean install -Dgroups="mytag"
mvn clean install -Dgroups="mytag | mytag2"
mvn clean install -Dgroups="mytag & mytag2"
mvn clean install -DexcludedGroups="mytag"
mvn clean install -Dcucumber.filter.tags=@Complete
mvn clean install -Dcucumber.filter.tags="@Complete and @APP_01"
mvn clean install -Dcucumber.filter.tags="@Conplete or @Acceptead"


mvn clean install -DbrowserName="chrome" -Dgroups="testsuite1"
mvn clean install -DbrowserName="edge" -Dgroups="testsuite1"

https://github.com/NagarajLakshatti2/Assignment-QA-Test-ESPN-NL
