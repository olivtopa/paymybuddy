## Organisation du code

Le back end (en spring) est dans src/main/java
Le front end (en react https://reactjs.org/) est dans src/main/js et src/main/resources/static (pour le style css et l'application buildée).
Le front end a également des fichiers complémentaires:
* le package.json listant les dépendances (c'est comme le pom)
* le package-lock.json listant la version des dépendances (pour comparer, le pom contient cette partie là)
* webpack.config.js: un fichier permettant de construire l'application front

Le fichier src/main/resources/templates/index.html est le fichier point d'entrée de l'application Front.

Les répertoires src/main/resources/static et src/main/resources/templates sont servis par le back-end: le back-end va les transmettre au client. C'est comme un site web.

## Comment démarrer le back-end
mvn spring-boot:run

## Comment installer le front-end

mvn frontend:install-node-and-npm

mvn frontend:npm install

Plus rapide: npm install directement

## Comment compiler le front-end
mvn frontend:npm run watch

Plus rapide: npm run watch
