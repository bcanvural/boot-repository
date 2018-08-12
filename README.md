# Spring boot app backed by Hippo Repository on MySQL

### Prerequisites

* Mysql server running locally on 3306 which has a schema named "repositoryDS"

* HippoCMS instance running as a cluster node

### Run with defaults:

```bash
$ mvn clean spring-boot:run
```

### Cluster-wide events

Spring boot app registers itself to cluster-wide events. Publish a document in HippoCMS and check the logs