#/bin/bash

#查找當前目錄下以.jpeg結尾的文件，將它們重新命名爲按序排列的文件。

i=21;
#需要轉義
for p in $(find ./* -name \*.jpeg);
    do mv $p "v2_0$i".jpeg;
let i=i+1;
done