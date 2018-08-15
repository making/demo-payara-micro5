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