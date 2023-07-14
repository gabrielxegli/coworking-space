## Coworking Space 

Dieses Projekt ist ein Management-System für Buchungen und die Benutzer eines Coworking Spaces, welches mit Quarkus entwickelt wird.

## Projekt aufsetzen
Stellen Sie sicher, dass die folgenden Software auf Ihrem System installiert ist:

- Visual Studio Code
- Java Development Kit (JDK 17)
- Maven (3.9.2)

1. Klonen Sie dieses Repository auf Ihr lokales System mit `git clone <repository-url>`.

Die Entwicklungsumgebung ist in [Development Containern](https://containers.dev/) organisiert.

2. Um den Dev Container zu starten, laden Sie bitte die VS Code Extension [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) herunter. Die Dienste starten dann automatisch.

## Projekt starten

Gestartet werden kann das Projekt mit der Quarkus Visual Studio Code Extension über den
Befehl `Quarkus: Debug Quarkus project`.

Alternativ kann das Projekt auch direkt über Maven gestartet werden.

```bash
./mvnw quarkus:dev
```

Der Webservice ist über Port **8080** erreichbar. Alle Testfälle laufen über diesen Port.

## Testdaten

Die automatisch eingeführten Testdaten werden in `TestDataService.java` gefunden.\
Die Testfälle wurden mit [Postman](https://www.postman.com/) gemacht und man findet sie unter `/Coworking.postman_collection.json`
Testfall Import [Anleitung](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#:~:text=In%20Postman%2C%20select%20Import%20to,3.0%20with%20a%20Postman%20Collection.)

## Quellen

- Vorlage für das ganze Projekt [4.2 Lösungsvorschlag](https://moodle.zli.ch/mod/resource/view.php?id=121212)
- Um Error-Messages zu interpretieren [ChatGPT](https://https://chat.openai.com/)
- Das Pre-Request-Script wurde von Nadim Bhatti erstellt
- ReadMe von Alexander Benak
