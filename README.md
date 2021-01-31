# MavenProject-HF
personal project
1. netty测试
2. springData集成MongoDB
3. 集成slf4jLog，log4j.properties文件直接放在src目录下则不需要配置加载路径的监听，如果放在其他目录下则需要配置加载log4j.properties文件路径的监听
4. 集成springMVC+Spring+Mybatis+Dubbo+zookeeper的开发环境
    1. 测试springMVC中的request和response的入参和出参乱码问题，配置CharacterEncodingFilter编码过滤器；设置tomcat的Encoding,配置springMVC的消息转换器。
    2. 注意：maven管理spring + springMVC + mybatis + dubbo项目打war包部署在tomcat时，需要将dubbo接口提供项目分别依赖到dubbo服务和消费端工程再部署到tomcat启动。
        1. 服务或消费war需要依赖接口工程：ctrl+shift+alt+s，设置当前项目的Artifacts，选择当前项目的war，然后选择dubbo接口提供工程右键点击put into output root即可。
    3. 注意：springMVC返回json到前端，需要依赖jackson相关依赖才能自动转换成json，否则会报错。