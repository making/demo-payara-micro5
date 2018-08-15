### Payara Micro on Cloud Foundry!!!


Just run

```
./mvnw clean package
cf push --random-route
```

You can access `https://demo-payara-micro5-<random-words>.cfapps.io`


```
cf map-route demo-payara-micro5 apps.internal -n demo-payara-micro5
cf add-network-policy demo-payara-micro5 --destination-app demo-payara-micro5 --protocol tcp --port 5701
```

```
cf scale demo-payara-micro5 -i 3
```

The new instances will join the hazelcast cluster automatically!

you will see the log like following:

```
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR [2018-08-15T18:11:39.728+0000] [] [INFO] [] [fish.payara.nucleus.cluster.PayaraCluster] [tid: _ThreadID=81 _ThreadName=hz._hzInstance_1_dev.event-5] [timeMillis: 1534356699728] [levelValue: 800] [[
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR   Data Grid Status 
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR Payara Data Grid State: DG Version: 35 DG Size: 3
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR Instances: {
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR Address: /10.254.84.175:5701 UUID: 18238847-96eb-419d-b39a-7a6b6c305efc Lite: false This: true Name: Drab-Cisco Group: MicroShoal
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR Address: /10.244.182.225:5701 UUID: 043f4375-b5dc-4b52-9b4b-57e99c8b282b Lite: false This: false Name: Splendid-Chimaera Group: MicroShoal
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR Address: /10.247.174.163:5701 UUID: b5442ded-c0d3-4f4b-9c25-6cd9706759ab Lite: false This: false
   2018-08-16T03:11:39.72+0900 [APP/PROC/WEB/2] ERR }]]
``` 