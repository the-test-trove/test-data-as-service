# drupal-test-data

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

Pre-Requisites
JDK 11 or Higher
MY SQL
Running the application in dev mode
You can run your application in dev mode that enables live coding using:

./mvnw compile quarkus:dev
NOTE: Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

The API Details.
**GET Articles.**

`Returns All the articles`

**Get Article.**

`Returns single article. The Article will be picked randomly from the Database.`

**Delete Article By ID**

`Deletes article provided as Query Paramter.`

**Update Article By ID**

`Update article provided as Query Paramter.`
