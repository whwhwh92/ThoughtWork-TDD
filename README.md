# README

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
git push   # 将已经commit的文件push（推送）到远端仓库，这会让其他人能够看到你的提交```

## 技术栈
* Java
* Gradle（构建工具，会使用即可）
* TDD（要练）

## 工具
* Intellij
* 

## 推荐的工具集

## 如何使用Gradle从零构建工具（选读）