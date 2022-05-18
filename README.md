# atlantis-backend

Dieses Repository ist das Backend (Rest-Api) für das Projekt Atlantis.

Einige Bemerkungen:

- für die Authentifizierung wird JWT benutzt
- die App folgt der bewährten Architektur Domain (Entity) / Repository / Services / Resources / DTO
- für die Konvertierung Entity <-> DTO wird mapstruct verwendet
- Lombok kommt nicht zum Einsatz, da Konstruktor & Co im IntelliJ im Nu angelegt werden können (besseres Kontroll)
- als Datenbank wird PostgreSql (gehostet on Heroku) benutzt
- die von der App erzeugten Nachrichten werden gem. der Spracheinstellung des Browsers (locale) wiedergegeben
- die ganze App wird in ein Docker Image gepackt und auf Heroku gehostet
- die Funktionen/Features wurden manuell getestet, deshalb gibt es keine Unittests

Created by: Balázs Varga, 2022