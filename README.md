# fare

[microservices-sample](https://github.com/n-ono/microservices-sample) の運賃を計算するサービス

## 各種コマンド

下記コマンドは全てプロジェクトのルートディレクトリで実行する

### ビルド

```
$ ./gradlew clean build
```

### Docker イメージ生成

```
$ docker build -t <image-name>:<tag> -f docs/docker/Dockerfile . 
```

`<image-name>` と `<tag>` は任意の値を指定する
