<p align="center">
  <img align="center" src="./assets/icon.svg" height="150px">
</p>

<h1 align="center">Java eAsistent API</h1>
<h3 align="center">JEA omogoča dostop do podatkov za vaš eAsistent račun.</h3>
<br>

<div align="center">

[![OTTF][ottf-shield]][ottf-url]
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

</div>

## Documentation
Vse metode so dokumentirane in opisane v odseku [Wiki][wiki-url].

## Installation
Zamenjajte VERSION z zadnjo različico iz [releases][releases-url].

### Maven
1. [Avtenticiraje se z GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages)

2. Dodajte repozitorij
```xml
<repository>
  <id>github</id>
  <url>https://maven.pkg.github.com/chocoearly44/jea</url>
  <snapshots>
    <enabled>true</enabled>
  </snapshots>
</repository>
```

3. Dodajte knjižnjico
```xml
<dependency>
  <groupId>tk.thesuperlab</groupId>
  <artifactId>jea</artifactId>
  <version>VERSION</version>
</dependency>
```

### Gradle
1. [Avtenticiraje se z GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages)

2. Dodajte repozitorij
```groovy
repositories {
  maven {
    url = uri("https://maven.pkg.github.com/chocoearly44/jea")
    credentials {
      username = System.getenv("USERNAME")
      password = System.getenv("TOKEN")
    }
  }
}
```

3. Dodajte knjižnjico
```groovy
dependencies {
  implementation 'tk.thesuperlab:jea:VERSION'
}
```

## Zahvale
Knjižnjica bazira na projektu eAsistent wrapper za Python, ki ga je naredil [LevecGG](https://github.com/LevecGG).

## Poročanje o napakah
Če med uporabo JEA naletite na kakršne koli napake, jih prijavite v odseku [Issues][issues-url].

## Podpora
Dodatno podporo lahko prejmete v odseku [Discussions][discussions-url].

[ottf-shield]: https://img.shields.io/badge/OTTF-v1.0-blueviolet?style=for-the-badge
[contributors-shield]: https://img.shields.io/github/contributors/chocoearly44/JEA.svg?style=for-the-badge
[forks-shield]: https://img.shields.io/github/forks/chocoearly44/JEA.svg?style=for-the-badge
[stars-shield]: https://img.shields.io/github/stars/chocoearly44/JEA.svg?style=for-the-badge
[issues-shield]: https://img.shields.io/github/issues/chocoearly44/JEA.svg?style=for-the-badge
[license-shield]: https://img.shields.io/github/license/chocoearly44/JEA.svg?style=for-the-badge

[ottf-url]: https://github.com/OpenTimetable/OpenTimetable-v1
[contributors-url]: https://github.com/chocoearly44/JEA/graphs/contributors
[forks-url]: https://github.com/chocoearly44/JEA/network/members
[stars-url]: https://github.com/chocoearly44/JEA/stargazers
[issues-url]: https://github.com/chocoearly44/JEA/issues
[license-url]: https://github.com/chocoearly44/JEA/blob/master/LICENSE
[wiki-url]: https://github.com/chocoearly44/JEA/wiki
[releases-url]: https://github.com/chocoearly44/JEA/releases
[discussions-url]: https://github.com/chocoearly44/JEA/discussions