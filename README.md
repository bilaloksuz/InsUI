# Koşum detayı
1- Lokal ortamda koşmak için pom dosyasındaki not okunmalıdır. 
2- Ayrıca RunTest.java içindeki Selenium grid start-Selenium grid end arasındaki kod bloğu yorum satırına alınmalıdır. (Default browser Chrome)

# Dosya içeriği
1- Docker-compose.yaml dosyası selenium grid kurmak adına yeterli içeriktedir. 
2- Proje path altında docker-compose up -d komutu çalıştırılınca selenium grid ve chrome-firefox node'ları ayağa kalkacaktır.
3- Testler selenium grid içerisinde koşabilmektedir.
4- Browser, Config-production.yaml içindeki değeri ile chrome veya firefox olarak ayarlanabilir.

# Notlar
1- Testler selenide ile yazılmıştır. 
2- Test kouşmu için selenium grid kullanılmıştır.
3- test-result klasörü altına ekran görüntüleri case içinde istendiği şekilde atılmaktadır.


# Runner detail
1- Note in pom file must be read to run in local environment.
2- Also, the code block between Selenium grid start and Selenium grid end in RunTest.java should be deleted/comment out. (Default browser Chrome)

# File content
1- Docker-compose.yaml file contains enough content to install selenium grid from docker.
2- When docker-compose up -d command is run under the project path, selenium grid and chrome-firefox nodes will be up.
3- Tests can run in the selenium grid.
4- The browser can be set to chrome or firefox with its value in Config-production.yaml.

# Notes
1- Tests are written in selenide.
2- Selenium grid is used for test run.
3- Screenshots are taken under the test-result folder as desired in the case.
