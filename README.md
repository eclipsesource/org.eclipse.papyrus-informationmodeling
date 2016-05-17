# Information Modeling
A Papyrus DSML for Information Modeling

### Repository structure ###

This repository is organized around logical software components:

* `core`: The core software components for Information Modeling.
* `releng`: Elements related to the creation of the rcp, update-site

### How to build ###

Components in this project are built using Maven and its Tycho plugin for the build of Eclipse artifacts.
To build locally, simply execute the command line:

```
mvn clean install
```

To also build the modules relative to RCP and Product, please activate the following profile:

```
mvn clean install -Pproduct
```

If you are building inside a specific Eclipse version (plugins), you will need to specify:

```
mvn clean install -Pproduct -Dtycho.localArtifacts=ignore
```

It is possible that you encounter some difficulties if you are working with several version of Papyrus in your Maven and Eclipse workspace.
So you can force tycho to download the right version by using:

```
mvn clean install -Dtycho.localArtifacts=ignore 

### Building against a specific Eclipse Release ###

By default information.modeling is build against Eclipse Neon.

### Building for Eclipser server ###

If you want to pack and sign the project, you have to use the following profiles:

```
-Peclipse-pack
```

and

```
-Peclipse-sign
```

## Hudson CI 
Build Status : ![Nightly Build Status](https://hudson.eclipse.org/papyrus/view/InformationModeling/job/papyrus-informationmodeling-neon/)

### How to change version ###

```
mvn -Dtycho.mode=maven org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=*new-version*-SNAPSHOT
```
Manual operation : change all Require-Bundle from bundle-version="*old-version*" to bundle-version="*new-version*"

Verify that the *new version* is present in : 
 - All Manifest.MF 
 - the root pom.xml
 - in category.xml