根据springai框架做的一个demo

因为springai的依赖在阿里云仓库中还没有，先改仓库为下面的
<mirror>
<id>maven-default-http-blocker</id>
<mirrorOf>external:http:*</mirrorOf>
<name>Pseudo repository to mirror external repositories initially using HTTP .</name>
<url>http://0.0.0.0/</url>
<blocked>true</blocked>
</mirror>
  </mirrors>
