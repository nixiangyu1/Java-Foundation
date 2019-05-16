# Git使用方法

参考视频:https://www.bilibili.com/video/av33238577/?p=1

进入想要创建库的地址  cd 

首先登陆用户名     git config --global user.name '用户名'

登陆email               git config --global user.email'邮箱'

创建库                     git init

与远端github相连       git remote add origin   远端地址

检查本地文件与github文件：git status

更新github文件:        git add 文件名字

​                                      git commit -m '说明'

推送到github:            git push -u origin master

