"Another Neat Tool (un autre chouette outil)
ant.apache.org

****************************

Avant propos
====================
* 2 * 3 créneaux
* Une évaluation sous la forme d'un devoir à rendre et des questions lors d'un DS sur table
* Ressources 
  * http://ant.apache.org/manual/index.html 
  * Un support pdf sur madoc 
  * + quelques liens sur madoc ! 


Motivation
====================
* *automatisation les opérations répétitives du cycle du développement* (compilation, test, génération de documentation, déploiement, versionning, ...) d'une application
* *indépendance envers toute plate-forme* (écrit en Java)
* *configuration déclarative* (via fichier XML) des opérations à exécuter
• *extensible* i.e. possibilité de créer ses propres tâches 

Premier aperçu du fichier de configuration `build.xml`
====================

`Makefile` Qu'est ce que c'est ? 

Un exemple simple de `build.xml`


Arborescence de fichiers
====================

Aucune restriction : flexibilité mais coût de prise en main ; nécessité de choisir à chaque projet

Conventions

* src code source de l’application
* test code source des tests unitaires
* lib dépendances (bibliothèques requises) du projets
* build tout fichier généré par le processus de construction
* build/classes les classes sources compilées
* build/test-classes les tests unitaires compilés
* dist fichier de distribution tel que jar ou war

Core, optional and third-party tasks
====================

* *core task* construit dans Ant, ne requiert pas de configuration spéciale
* *optional task* maintenu par l’équipe Ant et livré avec Ant, mais nécessitant des bibliothèques externes. Exemple : xalan.jar (XSL transformer), junit.jar, mail.jar, Groovy jars (scripts Java), jdepend.jar ...
* *third party task* écrit et maintenu hors du projet Ant. Exemple : Subversion fourni par Tigris (l’équipe qui maintient Subversion)

Ant 1.8 vient avec environ 100 core tasks et 50 optionnelles.
Ant 1.9 Java 1.5 is now required..

Aperçu de certaines tâches dans le support pdf de ce cours.

Sections optionnelles du fichier de configuration `build.xml`
====================

Consulter `introduction/ant_un-peu-plus-compliqué/build.xml`

Pré-requis : `Classpath` Qu'est ce que c'est ?  Cf. `jdk-tools.pdf` de S. Faucou sur madoc même module

* Les propriétés
* Les chemins/path


Les formes abrégées des classpath
====================

cf. support pdf de ce cours


Définir sa propre tâche
====================

cf. support pdf de ce cours


Trucs et astuces : 
====================

    ant # Par défaut, recherche un fichier build.xml dans le répertoire courant. Si aucune cible n'est spécifiée, il prendra celle déclarée par défault dans le fichier

    ant -buildfile monbuild.xml # Spécification d’un fichier de configuration autre que celui par défaut

    ant package # Exécution de la cible package et toutes les cibles dont elle dépend

    ant clean compile jar # Exécution de cibles en série

    ant -projecthelp # pour connaître les cibles et leur description disponibles dans le build.xml courant


Consignes générales 
====================

Travaillez en binôme.

Votre travail consistera à automatiser un projet de développement écrit en java ( [Inspiré fortement de ...](http://rpouiller.developpez.com/tutoriels/java/tests-unitaires-junit4)

Réalisez votre travail dans un répertoire nommé `nom1_nom2` 

Y inclure un fichier compte-rendu nommé `nom1_nom2`

Archivez le répertoire dans un fichier nommé
`[lpa|lpm]_nom1_nom2.zip` (par exemple `lpa_hernandez.zip`) 

Le compte-rendu indiquera les questions auxquels vous avez répondu de manière satisfaisante. 

Le mode de dépôt (mail ou Madoc ou uncloud) sera précisé ultérieurement    


Question 1 : code source du projet
====================
Se rendre dans le répertoire `exercice`

Décrivez brièvement les classes contenues dans les sous répertoires `source` et `test`.


Question 2 : commandes java
====================

Décrivez en français ce que réalise chacune des cinq commandes ci-dessous en explicitant leur paramétrage :

    mkdir -p build/classes
    javac -sourcepath src -d build/classes src/com/rpouiller/Operations.java
    echo "Main-Class: com.rpouiller.Operations">mf
    mkdir build/jar
    jar cfm build/jar/Operations.jar mf -C build/classes .
    java -jar build/jar/Operations.jar

Vous avez le droit d’exécuter les commandes pour vous aider à répondre à la question. Ne vous inquiétez pas du possible résultat incohérent de l’affichage.


Question 3 : un `build.xml` lisible et compréhensible
====================

Dans le fichier `build.xml` donné,

* Identifier le rôle de chaque cible et ajouter un attribut `description` adapté. Tester avec/sans l'attribut à l'aide de la commande `ant -projecthelp` 
* Spécifier un ordre d'exécution entre les cibles à l'aide de l'attribut `depends` 
* Finalement ajouter un nom, une cible par défaut appelé `main` et un répertoire de base au projet (cf. ligne d'en-tête)

La cible par défaut doit nettoyer le projet (i.e. supprimer tout ce qui a été précédemment généré), générer tout ce qui peut être généré, excuter les tests (à faire plus tard) et exécuter le code compilé de l'application. Il faudra la créer...

Pour la suite des questions, utiliser des commentaires `<!-- -->` et des attributs `description` pour expliciter votre travail et vos choix.


Question 4 : les propriétés
====================

Au moins 3 manières de définir une propriété vous ont été présentées : en ligne de commande, via un fichier propriétés externes, directement dans un build.xml (cf. l'introduction avec le build.xml de l'ant_un-peu-plus-compliqué). Dans l'éventualité où une même propriété serait définie plusieurs fois avec des valeurs différentes, quelle définition serait considérée ? La première ? La dernière ? Autre ? 


La tâche `<echoproperties/>` affiche toutes les propriétés définies au moment de l'exécution de la tâche. 

La variable d'environnement CLASSPATH (propriété `java.class.path`) et le répertoire de base `basedir` ainsi que les propriétés qui informent de la version de ant et celle de java utilisées sont-elles définies ? Créer une cible `try_echo_properties` pour cela.

Le [manuel de ant sur les propriétés](https://ant.apache.org/manual-1.9.x/properties.html) précise les propriétés qui sont prédéfinies dans ant et celles qui sont définies par le système. Celles qui n'y sont pas mentionnées sont définies par l'utilisateur.

Les propriétés `java.class.path`, `basedir` font-elles parties des propriétés pré-définis dans ant ?

Quelles propriétés permettent de connaître respectivement la version de ant et celle de java utilisée ?


Question 5 : généralisation du code à l'aide de propriétés
====================

Dans le build.xml fourni, des noms de  répertoires sont mentionnés plusieurs fois. Le nom de la classe principale et de l’archive jar sont codés en dur.

- Créez les propriétés `src.dir` et `build.dir` pour respectivement désigner les répertoires src et `build`.
- Créez les propriétés `classes.dir` et `jar` pour désigner respectivement deux sous-répertoires de `build/classes` et `jar`.
- Créez la propriété `main-class` pour désigner le nom de la classe principale (le nom d’une classe s’accompagne de son nom de package).
- Exploitez la propriété du nom du projet pour spécifier l’archive `jar` produite.

Par la suite définissez des propriétés pour chaque chemin, nom de fichiers... dont vous auriez besoin.


Question 6 : spécification locale du classpath
====================

Dupliquez la cible `run` et nommez cette nouvelle cible `run_classname_pathement`. Et incluez là dans la chaîne de dépendance en lieu et place de l'actuel `run`.

Dans cette nouvelle cible, réécrivez la tâche `java` avec l'attribut `classname` pour spécifier la classe principale et un élément `classpath` indiquant la localisation de l’archive jar du projet via un sous-élément pathelement.

Outre l'exemple *un peu plus compliqué*, le [manuel ant de la tâche java](https://ant.apache.org/manual/Tasks/java.html) donne des exemples d'usage (tout en bas).


Question 7 : utilisation d’une bibliothèque externe
====================

Nous allons étendre le code actuel pour journaliser les actions principales du main de la classe
`com.rpouiller.Operations.java`. Pour ce faire, nous utiliserons le projet [log4j](http://logging.apache.org/log4j/2.x/).

Modifiez la classe en rajoutant ces deux imports

    import org.apache.log4j.Logger;
    import org.apache.log4j.BasicConfigurator;

Déclarez globalement un "logger" avec la ligne suivante

    static Logger logger = Logger.getLogger(Operations.class);

Puis dans le main, rajoutez la ligne suivante

    BasicConfigurator.configure();

Et pour chaque ligne de code décrivant une opération rajoutez une ligne qui ressemble à

    logger.info("on journalise une addition");

Cette instruction correspond à l’ancienne façon d’obtenir des sorties système. Elle nous suffira dans le cadre de ce travail.

Une fois le code modifié, exécutez un `ant main`. Traduisez en français ce que signifie les messages que vous obtenez en console.

Attaquez vous au `build.xml`. Pour commencer, rajoutez une propriété `lib.dir` pointant vers le répertoire `lib`.

Dupliquez les cibles pour lesquelles vous souhaitez modifier le classpath d'une tâche. Nommez la nouvelle cible en ajoutant le suffixe `_cp_with_external_library`. Substituer les anciennes cibles avec ces nouvelles dans la chaîne de dépendance. 

Puis modifiez les `classpath` des tâches qui en ont besoin. Quelles sont les cibles et les tâches concernées ?

Dans la nouvelle version des tâches, spécifiez dans les classpath les localisations
vers les bibliothèques suivantes si nécessaire : `log4j-core-2.6.2.jar, log4j-1.2-api-2.6.2.jar,
log4j-api-2.6.2.jar`

Si vous obtenez l’erreur suivante

    [java] ERROR StatusLogger No log4j2 configuration file found.
    Using default configuration: logging only errors to the console.

alors sachez que le répertoire source contient un exemple du dit fichier (log4j2.xml). 
Vous pourriez faire disparaître le message et afficher les logs en console entre rajoutant la ligne suivante

    <pathelement location="${src.dir}"/>

dans le classpath de la tâche de la cible... qui va bien. Préférez de copier dans le classes.dir ce fichier lors de la phase de préparation de la construction à la compilation.

    <copy todir="${classes.dir}">
        <fileset dir="${src.dir}" excludes="**/*.java"/>
    </copy>

Si cela marche vous devriez voir un log console qui ressemble à
    
    00:34:55.069 [main] INFO com.rpouiller.Operations - on log une addition

Au final, les deux classpaths ainsi construits contiennent-ils la même chose ?


Question 8 : globalisation des classpath à l’aide de path
====================
Tout est dit. 

Tout d’abord créez un `path` auquel vous donnerez l’identifiant `classpath`. Ce path sera composé de "l'ensemble de fichiers" "incluant tous les fichiers avec l'extension jar" contenus dans le répertoire `lib`.

Ensuite dupliquez les cibles pour lesquelles vous allez modifier le classpath d'une tâche. Nommez les nouvelles cibles en ajoutant le suffixe `_cp_with_path`. Substituer les anciennes cibles avec ces nouvelles dans la chaîne de dépendance. 

Notez que : 
* `<path refid="classpath"/>` permet de faire référence à un path nommé classpath dans un élément classpath. 
* la tâche `javac` peut utiliser l’attribut `classpathref` pour faire référence à un path. 
* les références à des identifiants ne sont pas des propriétés et qu’ils ne s’accompagnent d’un dollars et d’accolades pour les désigner.


Question 9: compilation des tests
====================

Implémentez la cible `compile-test` qui fait appel à la tâche `javac` pour compiler le code des tests et placer les `.class` dans le répertoire `test-classes`.

Créez les répertoires cibles, les properties et path qui vont bien pour globaliser au mieux votre code. 

Vous exploiterez probablement le `jar` de l’application pour référencer le code métier de l’application. 

Il vous faudra aussi référencer la bibliothèque `junit` (actuellement présente dans le répertoire lib) dans le classpath. Cette cible ressemble beaucoup à la cible compile... Indiquez les propriétés créées, les paths créés, les cibles créées, les tâches+cibles avec un classpath modifiés.
De quelle(s) cible(s) dépend la cible compile-test selon vous ? Rajoutez la dépendance.


Question 10 : exécution des tests
====================

Implémentez la cible `junit`. Créez les `properties`, `path` et `target` qui vont bien (factorisez les chemins en dur dupliqués à l’aide d’un `path`).

Le code suivant devrait être opérationnel moyennant l’existence par exemple d’une cible `compile-test` ayant généré des .class des fichiers tests java dans un répertoire `build/test-classes`.

    <target name="junit" depends="compile-test">
        <mkdir dir="build/junittest"/>
        <junit printsummary="yes">
            <classpath>
                <path refid="classpath"/>
                <pathelement location="${jar.dir}/${ant.project.name}.jar"/>
            </classpath>
        <formatter type="xml"/>
        <batchtest fork="yes" todir="build/junittest">
            <fileset dir="build/test-classes" includes="**/*.class"/>
            </batchtest>
        </junit>
    </target>

* L’attribut `printsummary` permet d’obtenir plus d’information qu’un simple message "FAILED" (i.e. échec) or "PASSED" (i.e. succès).
* `formatter` indique le format de sortie des résumés. Il peut aussi avoir la valeur `plain` plus lisible mais le format `xml` permet de générer par la suite des rapports. 
* `batchtest` permet d’exécuter une batterie de tests et non seulement un seul.

Attention la tâche junit est une tâche optionnelle. Il vous faudra donc référencer la bibliothèque `junit.jar` dans son classpath.

Faire en sorte que l’exécution de ant ne s’arrête pas en cas d’echec et un affichage résumé sera produit.

Globalisez votre code et indiquez les propriétés créées, les paths créés, les cibles créées, les tâches+cibles avec un classpath modifiés.

Jetez un oeil aux resultats des tests produits. Si votre build.xml est correctement écrit, vous constaterez des `Errors` mais aussi des `Failures` (si vous avez que des Errors, votre code n’est pas correct, il se peut qu’il manque des choses dans vos classpath...). 
Quelles Errors et Failures constatez-vous (classe et méthode concernées, message du type d’error/failure) ? Vous pouvez utiliser la cible junitreport ci-après pour vous faciliter la lecture des résultats de test.
De quelle(s) cible(s) dépend la cible junit selon vous ? Rajoutez la/les dépendance(s).


Question 11 : rapport de tests
====================

Implémentez la cible `junitreport` qui utilise la tâche junitreport. Les rapports seront produits dans le repertoire `build/junitreport` où l’on trouvera un fichier index.html.

Le code suivant devrait fonctionner moyennant quelques adaptations.

    <target name="junitreport">
        <junitreport todir="build/junitreport">
            <fileset dir="build/junittest" includes="TEST-*.xml"/>
            <report todir="build/junitreport"/>
        </junitreport>
    </target>

Globalisez votre code et indiquez les propriétés créées, les paths créés, les cibles créées, les tâches+cibles avec un classpath modifiés.

Jetez un oeil aux rapports générés via l’index.html.

De quelle(s) cible(s) dépend la cible junit selon vous ? Rajoutez la/les dépendance(s).


Question 12 : génération de la javadoc
====================

Implémentez la cible `javadoc` qui utilise la tâche `javadoc`. La javadoc sera produit dans le repertoire `build/javadoc` où l’on trouvera un fichier index.html.

Le code suivant devrait fonctionner moyennant quelques adaptations.

    <target name="javadoc" description="Génération de la documentation Javadoc">
        <javadoc sourcepath="src"
            destdir="build/javadoc"
            packagenames="com.rpouiller"
            author="true"
            version="true"
            use="true"
            access="private"
            linksource="true"
            windowtitle="${ant.project.name} API">
            <classpath >
                <pathelement location="${jar.dir}/${ant.project.name}.jar"/>
            </classpath>
            <doctitle><![CDATA[<h1>${ant.project.name}</h1>]]></doctitle>
            <bottom><![CDATA[<i>Copyright &#169; 2000 Dummy Corp. All Rights Reserved.</i>]]></bottom>
            <tag name="todo" scope="all" description="To do:"/>
            <group title="Group 1 Packages" packages="com.dummy.test.a*"/>
            <group title="Group 2 Packages" packages="com.dummy.test.b*:com.dummy.test.c*"/>
            <link offline="true" href="http://java.sun.com/j2se/1.5.0/docs/api/" packagelistLoc="C:\tmp"/>
            <link href="http://developer.java.sun.com/developer/products/xml/docs/api/"/>
        </javadoc>
    </target>

Globalisez votre code et indiquez les propriétés créées, les paths créés, les cibles créées, les tâches+cibles avec un classpath modifiés.
Jetez un oeil à la javadoc générée via l’index.html.
De quelle(s) cible(s) dépend la cible junit selon vous ? Rajoutez la/les dépendance(s).


Question 13 : récupération des dépendances avec ivy2
====================

ivy2 est une technologie qui permet la récupération automatique des dépendances (les bibliothèques externes) d’un projet. Cela rend aussi possible le partage de celles-ci entre projet.

Nous allons l’expérimenter.

Dupliquez le projet `exercice` et renommez la nouvelle version en rajoutant le suffixe +ivy2 (pour s’y retrouver). 

Au sein de celui-ci supprimez le répertoire lib. Il sera automatiquement reconstruit.

Dans le `build.xml`, rajoutez l’espace de nom `xmlns:ivy="antlib:org.apache.ivy.ant"` dans
l’élément du project racine. Cela vise à simplifier l’écriture des éléments appartenant à ivy par la suite dans le document XML du build. 

Rajoutez la cible `resolve` qui sera chargé de récupérer automatiquement les dépendances
via la tâche `retrieve`. Le code suivant devrait faire l’affaire :

    <target name="resolve">
        <setproxy proxyhost="proxy-etu" proxyport="3128"/>
        <ivy:retrieve />
    </target>

La tâche `setproxy` sert à sortir de l’université... La tâche `ivy:retrieve` fonctionne à l’aide du fichier de configuration ivy.xml présent à la racine du projet. Un exemple de fichier se trouve disponible. Jetez un oeil pour voir les dépendances actuellement spécifiées. Les dépendances seront automatiquement récupérées/téléchargées depuis les serveurs qui vont bien du réseau Internet. Elles seront placées automatiquement dans le répertoire lib du projet.

Exécutez un `ant main` et en fonction de l’affichage console, modifiez le fichier de configuration pour rajouter les dépendances qui vont bien.

Ici quelques informations qui vont bien pour [utiliser log4j avec ivy2 et ant](https://logging.apache.org/log4j/2.x/maven-artifacts.html). Le nom de domaine des biblio-
thèques log4j-api... est org.apache.logging.log4j.


Question 14 : extension des tâches
====================
Créez la tâche additionner qui prendra deux arguments en paramètres. Ajoutez une cible qui teste votre tâche.


Pour aller plus loin
====================

Consulter les questions 15 à 17 de la version du sujet dite "deprecated" sur madoc


Pour vous aider
====================
vous avez à disposition :
- le support du cours (exemples et bibliographie notamment vers un manuel externe de svn à travers ant),
- le manuel ant de ant http://ant.apache.org/manual > section Ant tasks > section Overview of Ant Tasks
- Après avoir consulté les différents exemples et la bibliographie du cours, le tutoriel du manuel est un bon point de départ.

4. 
====================




====================


====================


====================