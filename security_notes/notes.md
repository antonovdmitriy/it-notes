## how to check certificate expiry date in p12

you need to know a password for p12. Then you need to extract pem and then check end date. 
```sh
openssl pkcs12 -in ./my_certs.p12 -nokeys -clcerts -out extracted_cert.pem
openssl x509 -in extracted_cert.pem -noout -enddate
```