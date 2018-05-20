# Java ActFramework implementation

This project is to implement the [web-rest-api-benchmark](https://github.com/mihaicracan/web-rest-api-benchmark) using [ActFramework](https://github.com/actframework/actframework).


**Note** when doing benchmark, make sure you [run the app in `prod` mode](#32-run-in-prod-mode).

## 1. Prerequisites

You must have Java SDK 8 and maven 3.5+ installed and environment path setup correctly.

## 2. Setup database configuration

Open [src/main/resources/conf/prod/db.properties](src/main/resources/conf/prod/db.properties) to setup database configuration for prod mode


## 3. Run the app

### 3.1 Run in dev mode

Type

```shell
./run_dev
```

Or

```shell
mvn compile act:run
```

When app is running in dev mode it uses database defined in [src/main/resources/conf/db.properties](src/main/resources/conf/db.properties). The current set up is a h2 database and generate the database file `benchmark.mv.db` on app start, no need to setup data and schema in this mode.

### 3.2 Run in prod mode

Type

```shell
./run_prod
```

or

```shell
mvn clean package
cd target/dist
tar xzf *.tar.gz
./run
```

When app is running in prod mode, it uses database defined in [src/main/resources/conf/prod/db.properties](src/main/resources/conf/prod/db.properties). The database schema and data must be exists before app start.

## 3.3 Run end to end test

Type

```shell
./run_e2e
```

or

```shell
mvn clean compile act:e2e
```

The will start the app on `e2e` profile, and it automatically run the end to end tests defined in [src/main/resources/e2e/scenarios.yml](src/main/resources/e2e/scenarios.yml)

**Note** when app is running on `e2e` profile, it also uses the same database setting with dev mode, which is defined in [src/main/resources/conf/db.properties](src/main/resources/conf/db.properties), which will not break your prod database defined in [src/main/resources/conf/prod/db.properties](src/main/resources/conf/prod/db.properties).

If you want to supply specific configuration for `e2e` profile, create an `e2e` dir under [src/main/resources/conf/](src/main/resources/conf/) and add a `.properties` file there.