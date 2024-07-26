# ChatDeleteMod

## 概要
このmodは指定した文字列を含むチャットを表示させなくするmodである。文字列はコマンドまたはGUIから追加・削除が可能である。


## 依存関係
1. modのバージョンに`ClothConfig`を含むものは[Cloth Config API](https://modrinth.com/mod/cloth-config)が必要である。
2. [Mod Menu](https://modrinth.com/mod/modmenu)が必要。
3. [Fabric API](https://modrinth.com/mod/fabric-api)が必要。

## コマンド一覧
+ `/ChatDeleteMod add [word]`<br>
  `[word]`で指定した文字列を追加する。
+ `/ChatDeleteMod list`<br>
  リスト内の文字列を**すべて**表示する。
+ `/ChatDeleteMod remove [word]`<br>
  `[word]`で指定した文字列を削除する。
+ `/ChatDeleteMod removeall`<br>
  リスト内の文字列を**すべて**削除する。

## 設定
- CensoredWords: `>`を押すとリスト内の文字列を閲覧・編集できる。`+`で追加する。追加するための入力欄が既存の文字列の下に表示される。文字列を選択した状態で`-`を押すことで削除する

## コントリビューション
バグ報告や機能追加の提案は、[Issues](https://github.com/kinchanramen/chatDeleteMod/issues)で行ってください。コードの貢献は、[Pull Requests](https://github.com/kinchanramen/chatDeleteMod/pulls)を通じて行っていただけます。

## ライセンス
このModは[MITライセンス](https://github.com/kinchanramen/chatDeleteMod/blob/master/LICENSE)の下で公開されています。

## 連絡先
- 開発者: [Kinchan_Ramen](https://github.com/kinchanramen)

## クレジット
- Fabric API
- Cloth Config API
- Mod Menu

