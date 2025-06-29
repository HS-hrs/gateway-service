# 빌드만 하는 스테이지
FROM eclipse-temurin:17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

# 실행 스테이지 필요한 부분만 카피한다. (경량화)
# 1. OpenJDK 17 기반 이미지 사용
FROM eclipse-temurin:17-jre-alpine

# 2. 작업 디렉토리 지정
WORKDIR /app

# 3. 빌드된 JAR 파일 복사 (경로 주의!)
COPY --from=build /app/build/libs/gateway-service-0.0.1-SNAPSHOT.jar app.jar

# 4. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]