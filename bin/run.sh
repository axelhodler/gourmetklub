#/bin/sh

export PORT=5111

mvn exec:java -Dexec.mainClass="co.hodler.GourmetKlub"
