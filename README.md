## Wildlife Tracker

An app for the forest service to track animals for an environmental impact study.

### Description

The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. This application was developed to allow Rangers to track wildlife sightings in the area.

### Specofications
|Behavior|Input|Output|
|App adds animal| Arachnid|Arachnid|
|App adds specific animal to animal family|Spider|Arachnid:Spider|
|App distinguishes between endangered animals| Is animal endangered?| Yes or no|
|App lists all animals and sightings|All animals| Spider, etc.|
|App adds Rangers| Add ranger - Rick| Rick|
|App adds specific animals and sightings to ranger| Ranger Rick - Add Arachnid-Spider|Rick-Arachnid_Spider|

###Technologies
This webpage was created using several technologies.
* 'java'
* 'Gradle'
* 'Github'
* 'Atom'
* 'Junit'
* 'Spark'
* 'Velocity Template Engine'

### Setup

To create the necessary databases, launch postgres, then psql, and run the following commands:


* `CREATE DATABASE wildlife_tracker;`
* `From Terminal psql < wildlife_tracker.sql`
* `\c wildlife_tracker;`
* If sql file does not work add following tables.
* `CREATE TABLE animals (id serial PRIMARY KEY, name varchar, ranger_id int);`
* `CREATE TABLE endangered_animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, ranger_id int);`
* `CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar, ranger_id int);`
* `CREATE TABLE rangers (id serial PRIMARY KEY, name varchar, email varchar, badgeNumber int);`
* `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`

* clone the repository
* run command `gradle run`
* open browser and go to localhost:4567

### Known Bugs
* 'rangers don't display on index after being submitted through form.'
* 'Ranger select form does not display all rangers.'


### License

Copyright (c) 2017 **_Jahan Walsh_** **_MIT License_**
