# Dive Log Practices

- spring boot single module practice

## 자동 구성(AutoConfigure)

 ```java
class AutoConfigurationImportSelector
|
|---getAutoConfigurationEntry
        getCandidateConfigurations

// ~ spring 3.x 까지 META-INF/spring.factories 에서 자동 구성 파일 사능
// spring 4.x 부터 META-INF/spring/ 안에 xx.imports 로 변경
```

- XXXAutoConfiguration 으로 끝남
- @EnableAutoConfiguration 어노테이션으로 활성화
- @Configuration
- @AutoConfigure~
- @ConditionalOnClass, @ConditionalOnMissingClass
- @ConditionalOnBean, @ConditionalOnMissingBean
- @ConditionalOnProperty

## 패키지 모듈 대체

```kotlin
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    modules {
        module("org.springframework.boot:spring-boot-starter-tomcat") {
            replacedBy("org.springframework.boot:spring-boot-starter-jetty", "모듈대체가능확인")
        }
    }
}
```