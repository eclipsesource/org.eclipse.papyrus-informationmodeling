# Papyrus Information Modeling
Papyrus Information Modeling is a Papyrus-based modeling product that is customized and streamlined for users interested in modeling the static structure of information with UML class diagrams. For more information, please also confer the [Eclipse Wiki](https://wiki.eclipse.org/Papyrus_for_Information_Modeling). This read-me file rather addresses developers and contributors.

## Code repository ##

The repository is hosted [Eclipse](http://git.eclipse.org/c/papyrus/org.eclipse.papyrus-informationmodeling.git). In addition, there is a clone on [Github](https://github.com/eclipsesource/org.eclipse.papyrus-informationmodeling).

This repository is organized around the logical software components:

* `plugins` includes the core software components for defining the Papyrus-based DSML (viewpoint, property views, styling, etc.), Eclipse UI simplifications, and a custom welcome page.
* `releng` contains elements related to the creation of the Eclipse rich client product and the p2 update-site.
* `targetplatform` defines the p2 repositories containing the dependencies used for building this product.
* `examples` contains example models acting as a documentation and help for getting started with this Papyrus-based DSML.

## Contributing ##

Open bugs are tracked on the [Eclipse Bugzilla](https://bugs.eclipse.org/bugs/buglist.cgi?bug_status=UNCONFIRMED&bug_status=NEW&bug_status=ASSIGNED&bug_status=REOPENED&classification=Modeling&component=Information%20Modeling&list_id=14557270&product=Papyrus&query_format=advanced). Please feel free to report [new bugs](https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Papyrus&component=Information%20Modeling) in the Papyrus Information Modeling component in Papyrus.

Please push patches to [Eclipse Gerrit](https://git.eclipse.org/r/#/q/project:papyrus/org.eclipse.papyrus-informationmodeling).

## Building the product ##

This product is built on the [Eclipse Hudson instance](https://hudson.eclipse.org/papyrus/view/InformationModeling/). In addition, the repository clone at Github is built at [Travis CI](https://travis-ci.org/eclipsesource/org.eclipse.papyrus-informationmodeling).

Build status of the master branch at *Travis CI*: [![Build Status](https://travis-ci.org/eclipsesource/org.eclipse.papyrus-informationmodeling.svg?branch=master)](https://travis-ci.org/eclipsesource/org.eclipse.papyrus-informationmodeling)

### Downloading the builds ###

The nightly builds can be downloaded for your platform from the following locations:

* [Papyrus Information Modeling based on Eclipse Neon for '''Windows 64bit'''](https://hudson.eclipse.org/papyrus/view/InformationModeling/job/papyrus-informationmodeling-neon/lastSuccessfulBuild/artifact/releng/org.eclipse.papyrus.information.modeling.product/target/products/org.eclipse.papyrus.information.modeling.product-win32.win32.x86_64.zip)
* [Papyrus Information Modeling based on Eclipse Neon for '''Linux 64bit'''](https://hudson.eclipse.org/papyrus/view/InformationModeling/job/papyrus-informationmodeling-neon/lastSuccessfulBuild/artifact/releng/org.eclipse.papyrus.information.modeling.product/target/products/org.eclipse.papyrus.information.modeling.product-linux.gtk.x86_64.zip)
* [Papyrus Information Modeling based on Eclipse Neon for '''MacOS X 64bit'''](https://hudson.eclipse.org/papyrus/view/InformationModeling/job/papyrus-informationmodeling-neon/lastSuccessfulBuild/artifact/releng/org.eclipse.papyrus.information.modeling.product/target/products/org.eclipse.papyrus.information.modeling.product-macosx.cocoa.x86_64.tar.gz)

### Building the product on your machine ###

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
```

### Building against a specific Eclipse Release ###

By default information.modeling is build against Eclipse Neon.

### Building for Eclipse server ###

If you want to pack and sign the project, you have to use the following profiles:

```
-Peclipse-pack
```

and

```
-Peclipse-sign
```

### How to change version ###

```
mvn -Dtycho.mode=maven org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=*new-version*-SNAPSHOT
```
Manual operation : change all Require-Bundle from bundle-version="*old-version*" to bundle-version="*new-version*"

Verify that the *new version* is present in: 
 - All Manifest.MF
 - the root pom.xml
 - in category.xml