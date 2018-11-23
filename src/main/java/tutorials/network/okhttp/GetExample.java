package tutorials.network.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 配置使用spring boot方法
 *
 * 如果8080端口被佔用，使用如下命令殺死當前佔用端口的進程。
 * sudo lsof -i:8080
 * sudo kill -9 進程號
 *
 * 如果jdk不夠新，更新jdk包。
 *
 * 如果已經配置nginx服務器，可以使用nginx+spring boot使用。
 *
 * vim /etc/nginx/conf.d/default.conf
 * 添加
 * location /spring/ {
 *         proxy_pass http://127.0.0.1:8080; #这里的端口记得改成项目对应。
 *         proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
 *         proxy_set_header X-Forwarded-Proto $scheme;
 *         proxy_set_header X-Forwarded-Port $server_port;
 * }
 *
 * 編譯
 * ./gradlew  build
 *
 * 執行
 * java -jar complete/build/libs/gs-rest-service-0.1.0.jar
 *
 */


public class GetExample {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("http://101.200.36.231/spring/greeting/");
        System.out.println(response);
    }
}
