# MavenProject-HF
personal project
1. netty测试
2. springData集成MongoDB
3. 集成slf4jLog，log4j.properties文件直接放在src目录下则不需要配置加载路径的监听，如果放在其他目录下则需要配置加载log4j.properties文件路径的监听
4. 集成springMVC+Spring+Mybatis+Dubbo+zookeeper的开发环境
    1. 测试springMVC中的request和response的入参和出参乱码问题，配置CharacterEncodingFilter编码过滤器；设置tomcat的Encoding,配置springMVC的消息转换器。