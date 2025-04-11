## Useful queries 

to see active instances

```
index=my_service env=my_test_env | stats count by bld, inst
```

graph to see response code distribution

```
index=my_service | timechart span=1h count by responseCode
```

to see response codes for different versions which is also included interesting version. To see if that errors happanes in more then one version icluding interesting version.

```
index=my_service ttl=AccessLogger responseCode NOT 200 responseCode NOT 204 responseCode NOT 210
| stats count, values(bld) as bld_list by ttl
| where  bld_list="012312"
| table url, count, bld_list
```

```
index=my_service env=my_test_env lvl=ERROR NOT ttl="AppStats: Found property error property file*" NOT ttl="Missing property file*" NOT ttl="*apns tap not successful for device*"
| stats count, values(bld) as bld_list by ttl
| where  bld_list="012312"
| table ttl, count, bld_list
```