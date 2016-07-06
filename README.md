# README

## 题目

[见这里](QUESTION.md)。

## 如何开始

将项目从git上clone到本地仓库：

```bash
git clone git@github.com:whwhwh92/ThoughtWork-TDD.git
```

进入工作目录，并使用gradle初始化项目：

```bash
cd ThoughtWork-TDD
./gradlew build
```

因为你们是两个人在同一个项目里进行操作，目前可以先在自己的分支上进行提交。把仓库拷贝下来后，执行以下操作创建你自己的一个分支，并关联到远端仓库：

```bash
git checkout -b 分支名  # 分支名自己起，比如李世豪的可以用自己的名字，最后的命令就是: git checkout -b lishihao

git push -u origin 分支名 # 分支名与上一步相同，比如: git push -u origin lishihao
```

## 如何提交

### 正常的提交代码工作流

```bash
git add .  # 先将更改的文件添加到git的管理，'.'表示全部添加
git commit # 将已经add的文件进行commit（提交），这个操作会让git真正记录提交
git push   # 将已经commit的文件push（推送）到远端仓库，这会让其他人能够看到你的提交
```

### Commit提交信息

在执行 `git commit` 的时候弹出的是vim编辑界面，不熟悉的话可以自行搜索。进入编辑的话，是先按 `i` 进入编辑模式，然后开始编辑，编辑完成后，依次按 `esc` `:` `wq` `回车` 完成并退出编辑。这步初次操作可能不熟，自己练熟，有问题可以找我。

提交信息格式见下面。

```bash
Your_name: Commit message body
```

下面举几个例子：

```bash 
Wanghuan: Remove gradle generated LibraryTest
Shihao: Add a test: reader should read json from file
Congyu: Init project with gradle init --type java-library
```

## 技术栈

* Java
* Gradle（构建工具，会使用即可）
* TDD（要练）

## 工具

* Intellij
* 

## 参考书籍
* TDD：[Kent Beck: Test-Driven Development 测试驱动开发](http://pan.baidu.com/s/1bpFRINX)
* 重构：[Martin Fowler: 重构——改善既有代码的设计](http://pan.baidu.com/s/1bpFRINX)
* 设计模式：[程杰：大话设计模式](http://pan.baidu.com/s/1bpFRINX)

## 推荐的工具集

## 如何使用Gradle从零构建工具（选读）