# 音楽のデータベースとCRUD処理を作成　　


## 概要  
1.SoringbootにてCRUD処理を実装  
⇨(id,title,singer)の値を持つMusicクラスを作成。(Musicのオブジェクトを使用した処理について実装していく)  

  
2.Dockerにて仮想環境を構築し、MySQLにてRDBとの接続を実装  
⇨GETで登録されているMusicテーブルの中のオブジェクトを取り出す。POSTでRDBに任意のMusicオブジェクトを登録。PATCHで選択したidのMusicオブジェクトを更新。DELETEで選択したidのMusicオブジェクトを削除  

  
3.上記のDBを使用したCRUD処理に対してのテストコードを実装  

## 作成背景  
私が音楽を聴いたりライブに行くことがとても好きなのですが、プレイリストのようなものを作成しても時期によって聞かなかったり飽きてしまったなと感じることがあります。  
そのような際に気軽に更新できたり、登録削除のできるアプリが欲しいなと思い、今回作成してみました。  

## 使用技術  
＜バックエンド＞

・Java 20.0.1
・SpringBoot 3.1.5
・MyBatis  

＜その他＞  

・MySQL 8.0.34
・Docker 23.0.5
・自動テスト
・Postman  

## アプリケーション概略図  

```mermaid  
flowchart TD
    subgraph "フロントエンド"
        Postman/Google

    end

    subgraph "バックエンド"

        コントローラー --> |処理の要求| サービス
        サービス --> |データ処理の要求| マッパー
        マッパー --> |処理結果の返却| サービス
        サービス --> |処理結果の返却| コントローラー
        Postman/Google --> |HTTP Request| コントローラー
        コントローラー --> |HTTP Response| Postman/Google
        Form <--> コントローラー
        end

    subgraph " "
        Entity

    Entity <--> コントローラー
    Entity <--> サービス
    Entity <--> マッパー
    end

    subgraph "データベース"
        Docker/MySQL
      マッパー --> |データベースの操作| Docker/MySQL
      Docker/MySQL --> |処理結果の返却| マッパー
    end
  ```



