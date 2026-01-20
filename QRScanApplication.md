-DCLIENT_PORT=8090
-DDB_PASSWORD=AVNS_ZYXlR98IJmnhaUy3E3Y
-DDB_USERNAME=avnadmin
-DDB_URL=jdbc:mysql://mysql-1ac4844e-suraj19rastogi-febd.e.aivencloud.com:21956/QRProfileApp?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
-DDRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
-DJPA_DB_PLATFORM=org.hibernate.dialect.MySQLDialect
-DJPA_SHOW_SQL=true
-DHIBERNATE_FORMAT_SQL=true
-DHIBERNATE_DDL_AUTO=update


CREATE TABLE IF NOT EXISTS QRProfileApp.user_details(
	user_id int NOT NULL AUTO_INCREMENT,
	user_token varchar(500),
	user_name varchar(100),
	user_email varchar(80),
	mobile varchar(10),
	expiry_time timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	is_user boolean default false,
	PRIMARY KEY ("user_id")

);

ngrok config 
AuthToken -- cr_38TYch2ksUEtAxctuC9BF9Qz9fa /cr_38TY4Bz2t1NCylDl3cpusAJ96l9
Session Status - online   
Account - Suraj Rastogi (Plan: Free)  
Version-3.35.0      
Region -India (in)   
Latency-80ms              
Web Interface-http://127.0.0.1:4040  
Forwarding-https://infinitesimally-venomless-hope.ngrok-free.dev -> http://localhost:8090   
ngrok url -  http://127.0.0.1:4040
  https://infinitesimally-venomless-hope.ngrok-free.dev -> http://localhost:8090 
  
Note--
Are you the developer?
We display this page to prevent abuse. Visitors to your site will only see it once.

To remove this page:
Set and send an ngrok-skip-browser-warning request header with any value.
Or, set and send a custom/non-standard browser User-Agent request header.
Or, please upgrade to any paid ngrok account.


Url- https://infinitesimally-venomless-hope.ngrok-free.dev/


----steps for NGrok
1.install ngrok 
2.get the authToken from ngrok dashboard "https://dashboard.ngrok.com/authtokens"
3.now open the ngrok in system run command
4.Config add authToken in ngrok 
-ngrok config add-authtoken "token"

5.exeute the ngrok 
ngrok http 8090

# SpringSecurityWithOAuth2
Implemented the Spring Security WIth the OAuth-2.0 in Microservices.
#. if any error of pull request rule voilation due to add the secret and password in the commit then use these git command
git checkout --orphan clean-main
git rm -rf --cached .
git add .
git commit -m "Clean config: remove all secrets and use env variables"
git branch -D main
git branch -m main
git push -u origin main --force
