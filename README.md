# Assignment

## Opis

Aplikacja webowa napisana w Spring Boot, której celem jest integracja z publicznym API GitHuba. Umożliwia pobranie wszystkich nieforkowanych repozytoriów wskazanego użytkownika oraz dla każdego z nich listy gałęzi (branchy) i ostatnich commitów.

Zawiera jeden test integracyjny, który sprawdza poprawność działania endpointu w scenariuszu pozytywnym (happy path).

------- 

## Uruchomienie projektu

1. Sklonuj repozytorium 
git clone https://github.com/darl1ng-design/assignment.git
cd assignment


2. Zbuduj projekt i uruchom

./mvnw spring-boot:run

** Alternatywnie można użyć IntelliJ lub innego IDE i uruchomić klasę GithubApiProjectApplication.java

3. Wykorzystaj endpoint

Po uruchomieniu aplikacji, przejdź do przeglądarki lub użyj narzędzia typu curl lub Postman

* Przeglądarka 
http://localhost:8080/api/github/repos/{nazwa_użytkownika} 

* Narzędzia curl / Postman
GET http://localhost:8080/api/github/repos/{nazwa_użytkownika}

 
## Przykładowa odpowiedź 
[
  {
    "repositoryName": "example",
    "owner": {
      "login": "darl1ng-design"
    },
    "fork": false,
    "branches": [
      {
        "branchName": "main",
        "commit": {
          "sha": "f1e2d3..."
        }
      }
    ]
  }
]

## Obsługa błędów
** W przypadku nieistniejącego użytkownika: 

{
    “status”: 404,
    “message”: "User not found"
}









