#!/bin/sh

#先要安裝jpegoptim軟件，壓縮質量還是挺好的。

for i in *.jpeg;
    do jpegoptim -d ./compressed -m20 "$i";
done
