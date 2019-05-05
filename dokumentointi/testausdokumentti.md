# Testausdokumentti

Ohjelmaa on testattu automatisoiduin yksikköteistein JUnitilla.

## Yksikkötestit

#### Sovelluslogiikka
Automatisoidut testit testaavat rpgame.domain pakkauksen luokkien toimintaa, eli esim. nopan silmälukuihin liittyviä totuusarvoja,
ja hahmo-olioiden elämänpisteiden vähenemistä.

#### Testikattavuus
Käyttöliittymän rakentamiseen liittyviä luokkia ei testata, sillä niissä tapahtuva mahdollinen vertailu nojaa domain pakkauksessa
sijaitsevien luokkien metodeihin.

Siispä käyttöliittymän rakentavaa koodia lukuunottamatta sovelluksen testauksen rivikattavuus on 93%, ja haarautumakattavuus on 100%.

## Järjestelmätestaus
Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

#### Asennus ja toiminta
Sovellksen toimintaa on testattu Linux- sekä Windows-ympäristöissä käyttöohjeen mukaisesti.
