# Spring boot app backed by Hippo Repository on MySQL/H2

### Prerequisites

Mysql server running locally on 3306 which has a schema named "repositoryDS"

###Run with defaults:

```bash
$ mvn clean spring-boot:run
```

###Run with parameters:

```bash
$ mvn clean spring-boot:run -Drepo.path=storage -Dorg.apache.jackrabbit.core.cluster.node_id=bootifulnode
```