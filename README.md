# RPGame #

Sovellus on yksinkertaista graafista käyttöliittymää hyödyntävä luettuun tekstiin perustuva *"Roolipeli"*. 

## Dokumentaatio
* [Käyttöohje](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/blob/master/dokumentointi/k%C3%A4ytt%C3%B6ohje.md)
* [alustava määrittelydokumentti](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/blob/master/dokumentointi/maarittelydokumentti.md)
* [työaikakirjanpito](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)
* [Arkkitehtuurikuvaus](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Releaset
* [viikko 5](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/releases/tag/viikko5)
* [viikko 6 *spoilers: is actually same release :(*](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/releases/tag/viikko5)


## Komentorivitoiminnot

***HUOM!** Komennoissa oletetaan että käyttäjä **on** kansiossa **RPGame***

### Testaus
Testit saa suoritettua komennolla `mvn test`

Testikattavuusraportin saa luotua komennolla `mvn jacoco:report`

*Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto **target/site/jacoco/index.html***

### Suoritettavan jarin generointi
Komennolla `mvn package`

*Suoritettava jar-tiedosto löytyy hakemistosta **target** nimellä **RPGame-1.0-SNAPSHOT.jar***

### Checkstyle
Tiedoston [checkstyle.xml](https://github.com/AlaNeponen/Ohjelmistotekniikka-harjoitustyo/blob/master/RPGame/checkstyle.xml) määrittelemät tarkistukset tehdään komennolla `mvn jxr:jxr checkstyle:checkstyle`

*Mahdollisia virheitä voidaan tarkastella avaamalla selaimella tiedosto **target/site/checkstyle.html***
